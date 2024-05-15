package com.me.workshop.workmongo.services.impl;

import com.me.workshop.workmongo.domain.User;
import com.me.workshop.workmongo.dto.request.UserRequestDTO;
import com.me.workshop.workmongo.dto.response.UserResponseDTO;
import com.me.workshop.workmongo.exceptions.ObjectNotFoundException;
import com.me.workshop.workmongo.repositories.UserRepository;
import com.me.workshop.workmongo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(user -> new UserResponseDTO(user)).toList();
    }

    @Override
    public Optional<UserResponseDTO> findById(String id) {
        return repository.findById(id)
                .map(user -> Optional.of(new UserResponseDTO(user)))
                .orElseThrow(() -> new ObjectNotFoundException("User with id not found: " + id));
    }

    @Override
    public UserResponseDTO insert(UserRequestDTO dto) {
        var user = repository.save(new User(dto.getName(), dto.getEmail()));
        return new UserResponseDTO(user);
    }
}

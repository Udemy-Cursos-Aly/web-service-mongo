package com.me.workshop.workmongo.services.impl;

import com.me.workshop.workmongo.dto.response.UserDTO;
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
    public List<UserDTO> findAll() {
        return repository.findAll().stream()
                .map(user -> new UserDTO(user)).toList();
    }

    @Override
    public Optional<UserDTO> findById(String id) {
        return repository.findById(id)
                .map(user -> Optional.of(new UserDTO(user)))
                .orElseThrow(() -> new ObjectNotFoundException("User with id not found: " + id));
    }
}

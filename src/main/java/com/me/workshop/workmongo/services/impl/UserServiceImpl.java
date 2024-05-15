package com.me.workshop.workmongo.services.impl;

import com.me.workshop.workmongo.dto.response.UserDTO;
import com.me.workshop.workmongo.repositories.UserRepository;
import com.me.workshop.workmongo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

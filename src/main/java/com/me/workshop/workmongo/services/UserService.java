package com.me.workshop.workmongo.services;

import com.me.workshop.workmongo.dto.response.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    Optional<UserDTO> findById(String id);
}

package com.me.workshop.workmongo.services;

import com.me.workshop.workmongo.dto.request.UserRequestDTO;
import com.me.workshop.workmongo.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDTO> findAll();
    Optional<UserResponseDTO> findById(String id);
    UserResponseDTO insert(UserRequestDTO dto);
    void delete(String id);
}

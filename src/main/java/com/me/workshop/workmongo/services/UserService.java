package com.me.workshop.workmongo.services;

import com.me.workshop.workmongo.payloads.request.UserRequestDTO;
import com.me.workshop.workmongo.payloads.response.PostsUserResponseDTO;
import com.me.workshop.workmongo.payloads.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDTO> findAll();
    Optional<UserResponseDTO> findById(String id);
    List<PostsUserResponseDTO> findPostsUser(String id);
    UserResponseDTO insert(UserRequestDTO dto);
    UserResponseDTO update(String id, UserRequestDTO dto);
    void delete(String id);
}

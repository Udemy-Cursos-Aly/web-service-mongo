package com.me.workshop.workmongo.services;

import com.me.workshop.workmongo.domain.User;
import com.me.workshop.workmongo.dto.response.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
}

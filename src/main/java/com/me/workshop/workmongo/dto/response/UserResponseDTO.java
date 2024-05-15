package com.me.workshop.workmongo.dto.response;

import com.me.workshop.workmongo.domain.User;

import java.io.Serializable;

public class UserResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;

    public UserResponseDTO() {}

    public UserResponseDTO(User entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

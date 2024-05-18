package com.me.workshop.workmongo.payloads.response;

import com.me.workshop.workmongo.domain.User;

public class UserResponseDTO {
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

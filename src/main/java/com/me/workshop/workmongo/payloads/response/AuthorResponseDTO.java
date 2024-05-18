package com.me.workshop.workmongo.payloads.response;

import com.me.workshop.workmongo.domain.User;

public class AuthorResponseDTO {
    private String id;
    private String name;

    public AuthorResponseDTO() {}

    public AuthorResponseDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

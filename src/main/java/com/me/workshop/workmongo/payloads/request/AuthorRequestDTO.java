package com.me.workshop.workmongo.payloads.request;

public class AuthorRequestDTO {
    private String id;
    private String name;

    public AuthorRequestDTO() {}

    public AuthorRequestDTO(String id, String name) {
        this.id = id;
        this.name = name;
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

package com.me.workshop.workmongo.dto.response;

import com.me.workshop.workmongo.domain.Post;

import java.util.Date;

public class PostsUserResponseDTO {
    private Date date;
    private String title;
    private String body;

    public PostsUserResponseDTO() {}

    public PostsUserResponseDTO(Post entity) {
        this.date = entity.getDate();
        this.title = entity.getTitle();
        this.body = entity.getBody();
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}

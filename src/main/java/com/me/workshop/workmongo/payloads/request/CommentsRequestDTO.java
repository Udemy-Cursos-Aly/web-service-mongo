package com.me.workshop.workmongo.payloads.request;

import java.util.Date;

public class CommentsRequestDTO {
    private String text;
    private Date date;
    private AuthorRequestDTO author;

    public CommentsRequestDTO() {}

    public CommentsRequestDTO(String text, Date date, AuthorRequestDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorRequestDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorRequestDTO author) {
        this.author = author;
    }
}

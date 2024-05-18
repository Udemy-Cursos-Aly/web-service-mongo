package com.me.workshop.workmongo.exceptions;

public class BodyNotFoundException extends RuntimeException{
    public BodyNotFoundException(String message) {
        super(message);
    }
}

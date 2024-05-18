package com.me.workshop.workmongo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new StandardError(LocalDate.now(), HttpStatus.NOT_FOUND.value(), "Not found", exception.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(BodyNotFoundException.class)
    public ResponseEntity<StandardError> bodyNotFound(BodyNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new StandardError(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), "Body is not empty", exception.getMessage(), request.getRequestURI()));
    }
}

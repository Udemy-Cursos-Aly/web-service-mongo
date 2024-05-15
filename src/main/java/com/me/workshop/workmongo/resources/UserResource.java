package com.me.workshop.workmongo.resources;

import com.me.workshop.workmongo.domain.User;
import com.me.workshop.workmongo.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ws/users")
public class UserResource {
    private final UserServiceImpl service;

    public UserResource(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        var users = service.findAll();
        return ResponseEntity.ok().body(users);
    }
}

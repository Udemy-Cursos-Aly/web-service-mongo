package com.me.workshop.workmongo.resources;

import com.me.workshop.workmongo.dto.response.UserDTO;
import com.me.workshop.workmongo.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ws/users")
public class UserResource {
    private final UserServiceImpl service;

    public UserResource(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> findAll() {
        var users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> findById(@PathVariable String id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}

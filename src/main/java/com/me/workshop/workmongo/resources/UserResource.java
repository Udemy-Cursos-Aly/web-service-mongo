package com.me.workshop.workmongo.resources;

import com.me.workshop.workmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ws/users")
public class UserResource {
    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        var maria = new User("1", "Maria", "maria@gmail.com");
        var alex = new User("2", "Alex", "alex@gmail.com");

        return ResponseEntity.ok().body(Arrays.asList(maria, alex));
    }
}

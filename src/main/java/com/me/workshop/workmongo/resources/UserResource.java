package com.me.workshop.workmongo.resources;

import com.me.workshop.workmongo.dto.request.UserRequestDTO;
import com.me.workshop.workmongo.dto.response.UserResponseDTO;
import com.me.workshop.workmongo.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        var users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDTO>> findById(@PathVariable String id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO requestDTO) {
        var user = service.insert(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(user.getName())
                .toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

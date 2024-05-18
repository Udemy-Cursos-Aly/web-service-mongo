package com.me.workshop.workmongo.resources;

import com.me.workshop.workmongo.payloads.request.UserRequestDTO;
import com.me.workshop.workmongo.payloads.response.PostsUserResponseDTO;
import com.me.workshop.workmongo.payloads.response.UserResponseDTO;
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

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostsUserResponseDTO>> findAllPostsUser(@PathVariable String id) {
        var posts = service.findPostsUser(id);
        return ResponseEntity.ok().body(posts);
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

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @RequestBody UserRequestDTO dto) {
        var user = service.update(id, dto);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

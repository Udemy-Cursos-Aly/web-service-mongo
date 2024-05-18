package com.me.workshop.workmongo.resources;

import com.me.workshop.workmongo.payloads.response.PostsUserResponseDTO;
import com.me.workshop.workmongo.services.impl.PostServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ws/posts")
public class PostResource {
    private final PostServiceImpl service;

    public PostResource(PostServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PostsUserResponseDTO>> findById(@PathVariable String id) {
        var post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }
}

package com.me.workshop.workmongo.resources;

import com.me.workshop.workmongo.helpers.HelperEncodeUrl;
import com.me.workshop.workmongo.payloads.response.PostsUserResponseDTO;
import com.me.workshop.workmongo.services.impl.PostServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/search")
    public ResponseEntity<List<PostsUserResponseDTO>> findByTitle(@RequestParam("text") String text) {
        text = HelperEncodeUrl.decodeParam(text);
        var post = service.findByTitle(text);

        return ResponseEntity.ok().body(post);
    }
}

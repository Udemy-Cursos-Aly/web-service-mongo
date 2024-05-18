package com.me.workshop.workmongo.services.impl;

import com.me.workshop.workmongo.exceptions.ObjectNotFoundException;
import com.me.workshop.workmongo.payloads.response.PostsUserResponseDTO;
import com.me.workshop.workmongo.repositories.PostRepository;
import com.me.workshop.workmongo.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<PostsUserResponseDTO> findById(String id) {
        return repository.findById(id)
                .map(post -> Optional.of(new PostsUserResponseDTO(post)))
                .orElseThrow(() -> new ObjectNotFoundException("Post with id not found: " + id));
    }

    @Override
    public List<PostsUserResponseDTO> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text).stream()
                .map(PostsUserResponseDTO::new).toList();
    }
}

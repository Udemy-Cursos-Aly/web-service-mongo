package com.me.workshop.workmongo.services;

import com.me.workshop.workmongo.payloads.response.PostsUserResponseDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostService {
    Optional<PostsUserResponseDTO> findById(String id);
    List<PostsUserResponseDTO> findByTitle(String text);
    List<PostsUserResponseDTO> findFullSearch(String text, Date minDate, Date maxDate);
}

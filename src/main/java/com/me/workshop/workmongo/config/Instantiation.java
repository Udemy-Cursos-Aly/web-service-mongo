package com.me.workshop.workmongo.config;

import com.me.workshop.workmongo.domain.Post;
import com.me.workshop.workmongo.domain.User;
import com.me.workshop.workmongo.payloads.request.AuthorRequestDTO;
import com.me.workshop.workmongo.repositories.PostRepository;
import com.me.workshop.workmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        postRepository.deleteAll();

        var molusco = new User(null, "Lula molusco", "molusco@gmail.com");
        var patrick = new User(null, "Patrick estrela", "patrick@gmail.com");
        var bob = new User(null, "Bob esponja", "bob@gmail.com");

        repository.saveAll(Arrays.asList(molusco, patrick, bob));

        var postOne = new Post(null, new Date(), "First post", "Hello world", new AuthorRequestDTO(bob.getId(), bob.getName()));
        var postTwo = new Post(null, new Date(), "Two post", "Hello my friend", new AuthorRequestDTO(patrick.getId(), patrick.getName()));

        postRepository.saveAll(Arrays.asList(postOne, postTwo));

        bob.setPosts(Arrays.asList(postOne));
        patrick.setPosts(Arrays.asList(postTwo));

        repository.saveAll(Arrays.asList(bob, patrick));
    }
}

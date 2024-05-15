package com.me.workshop.workmongo.config;

import com.me.workshop.workmongo.domain.User;
import com.me.workshop.workmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        var molusco = new User(null, "Lula molusco", "molusco@gmail.com");
        var patrick = new User(null, "Patrick estrela", "patrick@gmail.com");
        var bob = new User(null, "Bob esponja", "bob@gmail.com");

        repository.saveAll(Arrays.asList(molusco, patrick, bob));
    }
}

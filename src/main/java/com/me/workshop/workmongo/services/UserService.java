package com.me.workshop.workmongo.services;

import com.me.workshop.workmongo.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}

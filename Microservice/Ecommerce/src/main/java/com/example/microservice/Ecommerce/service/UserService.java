package com.example.microservice.Ecommerce.service;

import com.example.microservice.Ecommerce.model.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    boolean loginUser(User user);

    List<User> getAllUsers();
}

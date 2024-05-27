package com.example.microservice.Ecommerce.service.impl;


import com.example.microservice.Ecommerce.model.User;
import com.example.microservice.Ecommerce.repository.UserRepository;
import com.example.microservice.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean loginUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        return existingUser != null && existingUser.getPassword().equals(user.getPassword());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



}


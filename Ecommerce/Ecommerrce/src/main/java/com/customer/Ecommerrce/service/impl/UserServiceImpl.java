package com.customer.Ecommerrce.service.impl;

import com.customer.Ecommerrce.entity.User;
import com.customer.Ecommerrce.repository.UserRepository;
import com.customer.Ecommerrce.service.UserService;
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
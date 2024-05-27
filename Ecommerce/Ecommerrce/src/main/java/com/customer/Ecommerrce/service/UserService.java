package com.customer.Ecommerrce.service;

import com.customer.Ecommerrce.entity.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    boolean loginUser(User user);

    List<User> getAllUsers();
}

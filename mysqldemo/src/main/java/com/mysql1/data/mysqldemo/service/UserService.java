package com.mysql1.data.mysqldemo.service;

import com.mysql1.data.mysqldemo.entity.User;

public interface UserService {

     default void registerUser(User user) {

    }
}

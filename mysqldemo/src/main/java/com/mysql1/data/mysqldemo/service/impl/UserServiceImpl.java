package com.mysql1.data.mysqldemo.service.impl;

import com.mysql1.data.mysqldemo.entity.User;
import com.mysql1.data.mysqldemo.repository.UserRepository;
import com.mysql1.data.mysqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user)
{
    userRepository.save(user);
}
}

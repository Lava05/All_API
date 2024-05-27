package com.mysql.data.mysqltry.service;


import com.mysql.data.mysqltry.model.User;
import com.mysql.data.mysqltry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(User user) {
        User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return "Valid user!";
        } else {
            return "Invalid credentials!";
        }
    }
}


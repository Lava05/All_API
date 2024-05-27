package com.mysql.data.mysqltry.Controller;

import com.mysql.data.mysqltry.model.User;
import com.mysql.data.mysqltry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return "Valid user!";
        } else {
            return "Invalid credentials!";
        }
    }
}

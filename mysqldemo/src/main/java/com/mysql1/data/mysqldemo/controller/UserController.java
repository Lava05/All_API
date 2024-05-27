package com.mysql1.data.mysqldemo.controller;


import com.mysql1.data.mysqldemo.entity.User;
import com.mysql1.data.mysqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user)
    {
        userService.registerUser(user);
        return "User Registered Successfully";
    }
}

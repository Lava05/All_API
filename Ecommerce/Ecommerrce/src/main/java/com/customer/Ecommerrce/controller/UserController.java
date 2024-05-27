package com.customer.Ecommerrce.controller;

import com.customer.Ecommerrce.entity.User;
import com.customer.Ecommerrce.repository.UserRepository;
import com.customer.Ecommerrce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        // Inject UserRepository
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user) {
        boolean loginSuccessful = userService.loginUser(user);
        if (loginSuccessful) {
            // Return a JSON object with a success message
            return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
        } else {
            // Return a JSON object with an error message
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Invalid credentials\"}");
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

}

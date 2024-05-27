package com.ui.uiapi.controller;

import com.ui.uiapi.dto.UserNameUpdateDTO;
import com.ui.uiapi.servicce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ui.uiapi.entity.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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


    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found\"}");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(Math.toIntExact(id)); // Assuming User class has setId method
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok().body("{\"message\": \"User updated successfully\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"User not found\"}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("{\"message\": \"User deleted successfully\"}");
    }


    @PatchMapping("/update_name/{id}")
    public ResponseEntity<Object> updateUserName(@PathVariable Long id, @RequestBody UserNameUpdateDTO userNameUpdateDTO) {
        boolean updateSuccessful = userService.updateUserName(id, userNameUpdateDTO);
        if (updateSuccessful) {
            return ResponseEntity.ok().body("{\"message\": \"Username updated successfully\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"User not found\"}");
        }
    }

}

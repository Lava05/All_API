package com.api.Hibernate.controller;


import com.api.Hibernate.entity.User;
import com.api.Hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        User user = userService.getUserById(Math.toIntExact(id));
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found\"}");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setEmployeeID(id);
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok().body("{\"message\": \"User updated successfully\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"User not found\"}");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        userService.deleteUser(Math.toIntExact(id));
        return ResponseEntity.ok().body("{\"message\": \"User deleted successfully\"}");
    }




}

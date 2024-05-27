package com.trial.springboot.Hellotry;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private static final String USERS_FILE = "users.json";

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        try {
            List<User> users = getUsers();
            users.add(user);
            saveUsers(users);
            Map<String, String> response = new HashMap<>();
            response.put("message", "User registered successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Error registering user. Please try again later."));
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestParam String username, @RequestParam String password) {
        try {
            List<User> users = getUsers();
            for (User storedUser : users) {
                if (storedUser.getUserName() != null && storedUser.getUserName().equals(username)
                        && storedUser.getPassword().equals(password)) {
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Login successful");
                    return ResponseEntity.ok(response);
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Invalid username or password"));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Error logging in. Please try again later."));
        }
    }


    private List<User> getUsers() throws IOException {
        List<User> users = new ArrayList<>();
        File file = new File(USERS_FILE);
        if (!file.exists()) {
            file.createNewFile(); // Create the file if it doesn't exist
        } else {
            // Print out the absolute path
            System.out.println("Absolute path of users.json: " + file.getAbsolutePath());

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    users.add(parseUser(line));
                }
            }
        }
        return users;
    }



    private void saveUsers(List<User> users) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(USERS_FILE))) {
            for (User user : users) {
                out.println(userToJson(user));
            }
        }
    }

    private User parseUser(String line) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(line, User.class);
    }

    private String userToJson(User user) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }
}

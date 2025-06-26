package com.example.sharengoB.controller;

import com.example.sharengoB.model.User;
import com.example.sharengoB.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5174") // React frontend dev server
public class AuthController {

    @Autowired
    private UserService userService;

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody User user) {
        if (user.getEmail() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body(new ApiResponse("Email and password are required"));
        }

        String result = userService.registerUser(user);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        if (loginUser.getEmail() == null || loginUser.getPassword() == null) {
            return ResponseEntity.badRequest().body(new ApiResponse("Email and password are required"));
        }

        User user = userService.validateUser(loginUser.getEmail(), loginUser.getPassword());
        if (user != null) {
            return ResponseEntity.ok(new LoginResponse("Login successful", user));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse("Invalid email or password"));
        }
    }

    // Response wrapper classes
    @Data
    @AllArgsConstructor
    static class ApiResponse {
        private String message;
    }

    @Data
    @AllArgsConstructor
    static class LoginResponse {
        private String message;
        private User user;
    }
}

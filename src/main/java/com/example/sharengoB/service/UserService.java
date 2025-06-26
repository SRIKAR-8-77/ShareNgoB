package com.example.sharengoB.service;

import com.example.sharengoB.model.User;
import com.example.sharengoB.model.UserProfile;
import com.example.sharengoB.repository.UserProfileRepository;
import com.example.sharengoB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository; // Inject UserProfile repo

    public String registerUser(User user) {
        // Check if user with email exists
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            return "User with email already exists";
        }
        // Save user
        userRepository.save(user);

        // Create an empty UserProfile for the new user
        UserProfile profile = UserProfile.builder()
                .email(user.getEmail())
                .name(user.getName())
                .bio("")
                .profileImage(null)
                .coverImage(null)
                .imageUrl(null)
                .coverUrl(null)
                .build();

        userProfileRepository.save(profile);

        return "User registered successfully";
    }

    // Validate user credentials and return User object if valid, else null
    public User validateUser(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // In real app, password should be hashed and checked securely
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}

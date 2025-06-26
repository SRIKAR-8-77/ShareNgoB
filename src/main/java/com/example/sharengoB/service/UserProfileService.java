package com.example.sharengoB.service;

import com.example.sharengoB.model.UserProfile;
import com.example.sharengoB.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    public Optional<UserProfile> getProfile(String email) {
        return repository.findByEmail(email);
    }

    public Optional<UserProfile> getProfileById(Long id) {
        return repository.findById(id);
    }


    public String saveProfileImage(String email, MultipartFile file) throws IOException {
        Optional<UserProfile> optional = repository.findByEmail(email);
        if (optional.isPresent()) {
            UserProfile profile = optional.get();
            profile.setProfileImage(file.getBytes());
            profile.setImageUrl("/api/profile/image-view/" + profile.getId());
            repository.save(profile);
            return "Profile image uploaded";
        } else {
            throw new RuntimeException("Profile not found");
        }
    }

    public String saveCoverImage(String email, MultipartFile file) throws IOException {
        Optional<UserProfile> optional = repository.findByEmail(email);
        if (optional.isPresent()) {
            UserProfile profile = optional.get();
            profile.setCoverImage(file.getBytes());
            profile.setCoverUrl("/api/profile/cover-view/" + profile.getId());
            repository.save(profile);
            return "Cover image uploaded";
        } else {
            throw new RuntimeException("Profile not found");
        }
    }
}
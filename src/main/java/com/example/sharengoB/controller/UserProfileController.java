package com.example.sharengoB.controller;

import com.example.sharengoB.model.UserProfile;
import com.example.sharengoB.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = {
        "http://localhost:5174",
        "https://share-ngo-frontend-o1ka.vercel.app"
})

public class UserProfileController {

    @Autowired
    private UserProfileService service;


    @GetMapping("/{email}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable String email) {
        return service.getProfile(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/image/{email}")
    public ResponseEntity<String> uploadProfileImage(
            @PathVariable String email,
            @RequestParam("file") MultipartFile file) throws IOException {
        String result = service.saveProfileImage(email, file);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/cover/{email}")
    public ResponseEntity<String> uploadCoverImage(
            @PathVariable String email,
            @RequestParam("file") MultipartFile file) throws IOException {
        String result = service.saveCoverImage(email, file);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/image-view/{id}")
    public ResponseEntity<byte[]> viewProfileImage(@PathVariable Long id) {
        return service.getProfileById(id)
                .filter(p -> p.getProfileImage() != null)
                .map(p -> ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(p.getProfileImage()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cover-view/{id}")
    public ResponseEntity<byte[]> viewCoverImage(@PathVariable Long id) {
        return service.getProfileById(id)
                .filter(p -> p.getCoverImage() != null)
                .map(p -> ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(p.getCoverImage()))
                .orElse(ResponseEntity.notFound().build());
    }


}

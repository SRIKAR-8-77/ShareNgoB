package com.example.sharengoB.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String bio;

    @Lob
    private byte[] profileImage;  // Store profile image

    @Lob
    private byte[] coverImage;    // Store cover image

    private String imageUrl;      // URL to view profile image
    private String coverUrl;      // URL to view cover image
}
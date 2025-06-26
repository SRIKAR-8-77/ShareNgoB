package com.example.sharengoB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String occupation;
    private String message;
    private int rating;

    public Feedback() {
        // Default constructor for JPA
    }

    public Feedback(String name, String email, String occupation, String message, int rating) {
        this.name = name;
        this.email = email;
        this.occupation = occupation;
        this.message = message;
        this.rating = rating;
    }
}

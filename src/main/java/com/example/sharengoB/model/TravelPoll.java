package com.example.sharengoB.model;

import jakarta.persistence.*;

@Entity
public class TravelPoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;

    private String destination;
    private String date;
    private String description;
    private int votes; // Make sure this field exists



    // ✅ Add Getters and Setters

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getVotes() {
        return votes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
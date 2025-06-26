package com.example.sharengoB.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickup;

    @Column(name = "drop_location")
    private String drop;

    private String date;
    private String time;
    private String vehicleType;
    private int seatsLeft;
    @Column(nullable = false)
    private String userEmail;
}


package com.example.sharengoB.repository;

import com.example.sharengoB.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByUserEmail(String email);
}


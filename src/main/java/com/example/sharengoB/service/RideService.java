package com.example.sharengoB.service;

import com.example.sharengoB.model.Ride;
import com.example.sharengoB.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public List<Ride> getRidesByUserEmail(String email) {
        return rideRepository.findByUserEmail(email);
    }

}


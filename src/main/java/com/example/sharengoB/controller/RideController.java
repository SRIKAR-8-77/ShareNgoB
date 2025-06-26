package com.example.sharengoB.controller;

import com.example.sharengoB.model.Ride;
import com.example.sharengoB.service.RideService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
@CrossOrigin(origins = "http://localhost:5174")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping
    public Ride shareRide(@RequestBody Ride ride) {
        return rideService.saveRide(ride);
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/user/{email}")
    public List<Ride> getRidesByUserEmail(@PathVariable String email) {
        return rideService.getRidesByUserEmail(email);
    }

}


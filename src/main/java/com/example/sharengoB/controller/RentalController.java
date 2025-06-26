package com.example.sharengoB.controller;

import com.example.sharengoB.model.Rental;
import com.example.sharengoB.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@CrossOrigin(origins = {
        "http://localhost:5174",
        "https://share-ngo-frontend-o1ka.vercel.app"
})

public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.saveRental(rental);
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    @GetMapping("/user/{email}")
    public List<Rental> getRentalsByEmail(@PathVariable String email) {
        return rentalService.getRentalsByUserEmail(email);
    }
}

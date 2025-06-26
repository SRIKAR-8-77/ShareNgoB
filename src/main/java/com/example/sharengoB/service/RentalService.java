package com.example.sharengoB.service;

import com.example.sharengoB.model.Rental;
import com.example.sharengoB.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public List<Rental> getRentalsByUserEmail(String email) {
        return rentalRepository.findByUserEmail(email);
    }

}


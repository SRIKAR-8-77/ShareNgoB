package com.example.sharengoB.repository;

import com.example.sharengoB.model.TravelPoll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelPollRepository extends JpaRepository<TravelPoll, Long> {
    List<TravelPoll> findByUserEmail(String email);
}


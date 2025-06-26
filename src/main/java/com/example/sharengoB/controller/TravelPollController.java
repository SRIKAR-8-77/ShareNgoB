package com.example.sharengoB.controller;

import com.example.sharengoB.model.TravelPoll;
import com.example.sharengoB.repository.TravelPollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel-polls")
@CrossOrigin(origins = {
        "http://localhost:5174",
        "https://share-ngo-frontend-o1ka.vercel.app"
})

public class TravelPollController {

    @Autowired
    private TravelPollRepository pollRepo;

    @GetMapping
    public List<TravelPoll> getAllPolls() {
        return pollRepo.findAll();
    }

    @PostMapping
    public TravelPoll createPoll(@RequestBody TravelPoll poll) {
        return pollRepo.save(poll);
    }

    @PutMapping("/{id}/vote")
    public TravelPoll votePoll(@PathVariable Long id) {
        TravelPoll poll = pollRepo.findById(id).orElseThrow();
        poll.setVotes(poll.getVotes() + 1);
        return pollRepo.save(poll);
    }

    @GetMapping("/user/{email}")
    public List<TravelPoll> getPollsByUser(@PathVariable String email) {
        return pollRepo.findByUserEmail(email);
    }


}


package com.example.sharengoB.service;

import com.example.sharengoB.model.Feedback;
import com.example.sharengoB.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public boolean hasFeedbackByEmail(String email) {
        return feedbackRepository.findByEmail(email).isPresent();
    }

}

package com.example.sharengoB.controller;

import com.example.sharengoB.model.Feedback;
import com.example.sharengoB.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = {
        "http://localhost:5174",
        "https://share-ngo-frontend-o1ka.vercel.app"
})
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<?> submitFeedback(@RequestBody Feedback feedback) {
        if (feedbackService.hasFeedbackByEmail(feedback.getEmail())) {
            return ResponseEntity.status(409).body("Feedback already submitted by this user.");
        }

        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }
}


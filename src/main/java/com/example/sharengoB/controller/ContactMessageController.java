package com.example.sharengoB.controller;

import com.example.sharengoB.model.ContactMessage;
import com.example.sharengoB.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {
        "http://localhost:5174",
        "https://share-ngo-frontend-o1ka.vercel.app"
})

public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;

    @PostMapping
    public ContactMessage submitContactMessage(@RequestBody ContactMessage message) {
        return contactMessageService.saveMessage(message);
    }
}


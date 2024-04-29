package com.example.adwise.controllers;

import com.example.adwise.DTO.ProfileDTO;
import com.example.adwise.exceptions.UserAlreadyExistsException;
import com.example.adwise.services.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController (RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<?> registerProfile(@Valid @RequestBody ProfileDTO profile) {
        try {
            return ResponseEntity.ok(this.registrationService.registerProfile(profile));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

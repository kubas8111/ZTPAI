package com.example.adwise.controllers;

import com.example.adwise.entities.Profile;
import com.example.adwise.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfilesController {
    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/add")
    public String addProfile(@RequestParam String email, @RequestParam String password) {
        Profile profile = new Profile();
        profile.setEmail(email);
        profile.setPassword(password);
        profileRepository.save(profile);
        return "Added new user";
    }

    @GetMapping("/list")
    public Iterable<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Profile findProfileById(@PathVariable Integer id) {
        return profileRepository.findProfileByProfileId(id);
    }
}

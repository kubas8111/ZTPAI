package com.example.adwise.services;

import com.example.adwise.entities.Profile;
import com.example.adwise.repositories.ProfileRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileSharedService {
    private final ProfileRepository profileRepository;
    private PasswordEncoder passwordEncoder;

    public ProfileSharedService(ProfileRepository profileRepository, PasswordEncoder passwordEncoder) {
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Profile> getProfileById(Long id) {
        return this.profileRepository.findById(id);
    }

    public List<Profile> getAllProfiles() {
        return (List<Profile>) this.profileRepository.findAll();
    }

    public Profile getProfileByEmail(String email) {
        try {
            return this.profileRepository.findByEmail(email);
        } catch (Exception e) {
            return new Profile();
        }
    }

    public boolean emailExists(String email) {
        Profile profile = this.profileRepository.findByEmail(email);
        return profile != null && profile.getEmail() != null;
    }

    public Profile saveProfile(Profile profile) {
        return this.profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        this.profileRepository.deleteById(id);
    }

    public String encodePassword(String password) {
        return this.passwordEncoder.encode(password);
    }

    public Boolean decodePassword(String password, String email) {
        Profile profile = this.profileRepository.findByEmail(email);

        if (profile == null || profile.getEmail() == null) {
            return false;
        }

        return this.passwordEncoder.matches(password, profile.getPassword());
    }
}

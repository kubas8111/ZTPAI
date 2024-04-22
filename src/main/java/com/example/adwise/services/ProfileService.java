package com.example.adwise.services;

import com.example.adwise.DTO.ProfileDTO;
import com.example.adwise.entities.Profile;
import com.example.adwise.exceptions.ResourceNotFoundException;
import com.example.adwise.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Iterable<ProfileDTO> getAllProfiles() {
        Iterable<Profile> profiles = profileRepository.findAll();
        List<ProfileDTO> profileDTOs = new ArrayList<>();
        profiles.forEach(profile -> profileDTOs.add(convertToDto(profile)));
        return profileDTOs;
    }

    public ProfileDTO getProfileById(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + id));
        return convertToDto(profile);
    }

    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        Profile profile = convertToEntity(profileDTO);
        Profile createdProfile = profileRepository.save(profile);
        return convertToDto(createdProfile);
    }

    public ProfileDTO updateProfile(Long id, ProfileDTO profileDTO) {
        Profile existingProfile = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + id));

        existingProfile.setEmail(profileDTO.getEmail());
        existingProfile.setPassword(profileDTO.getPassword());
        existingProfile.setFirstName(profileDTO.getFirstName());
        existingProfile.setLastName(profileDTO.getLastName());
        existingProfile.setPhone(profileDTO.getPhone());
        existingProfile.setRole(profileDTO.getRole());

        Profile updatedProfile = profileRepository.save(existingProfile);
        return convertToDto(updatedProfile);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    private ProfileDTO convertToDto(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setProfileId(profile.getProfileId());
        profileDTO.setEmail(profile.getEmail());
        profileDTO.setPassword(profile.getPassword());
        profileDTO.setFirstName(profile.getFirstName());
        profileDTO.setLastName(profile.getLastName());
        profileDTO.setPhone(profile.getPhone());
        profileDTO.setRole(profile.getRole());
        return profileDTO;
    }

    private Profile convertToEntity(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setProfileId(profileDTO.getProfileId());
        profile.setEmail(profileDTO.getEmail());
        profile.setPassword(profileDTO.getPassword());
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setPhone(profileDTO.getPhone());
        profile.setRole(profileDTO.getRole());
        return profile;
    }
}

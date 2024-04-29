package com.example.adwise.services;

import com.example.adwise.DTO.ProfileDTO;
import com.example.adwise.entities.Profile;
import com.example.adwise.exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final ProfileSharedService profileSharedService;

    public RegistrationService(ProfileSharedService profileSharedService) {
        this.profileSharedService = profileSharedService;
    }

    public ProfileDTO registerProfile(ProfileDTO requestProfile) throws UserAlreadyExistsException {
        if (this.profileSharedService.emailExists(requestProfile.getEmail())) {
            throw new UserAlreadyExistsException("User with that email already exists");
        }

        requestProfile.setPassword(this.profileSharedService.encodePassword(requestProfile.getPassword()));
        Profile savedProfile = this.profileSharedService.saveProfile(requestProfile.convertToEntity());

        return this.convertToDTO(savedProfile);
    }

    private ProfileDTO convertToDTO(Profile profile) {
        ProfileDTO dto = new ProfileDTO();
        dto.setProfileId(profile.getProfileId());
        dto.setEmail(profile.getEmail());
        dto.setPassword(profile.getPassword());
        dto.setFirstName(profile.getFirstName());
        dto.setLastName(profile.getLastName());
        dto.setPhone(profile.getPhone());
        dto.setIsAdmin(profile.getIsAdmin());

        return dto;
    }
}

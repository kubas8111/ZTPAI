package com.example.adwise.services;

import com.example.adwise.DTO.JwtDTO;
import com.example.adwise.DTO.LoginDTO;
import com.example.adwise.DTO.RefreshDTO;
import com.example.adwise.configuration.JwtTokenUtil;
import com.example.adwise.entities.Profile;
import com.example.adwise.exceptions.ExpiredRefreshTokenException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final ProfileSharedService profileSharedService;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthService(ProfileSharedService profileSharedService, JwtTokenUtil jwtTokenUtil) {
        this.profileSharedService = profileSharedService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public JwtDTO loginProfile(LoginDTO profile) throws BadCredentialsException {
        if (!this.profileSharedService.decodePassword(profile.getPassword(), profile.getEmail())) {
            throw new BadCredentialsException("Wrong email or password");
        }

        Profile signedInProfile = this.profileSharedService.getProfileByEmail(profile.getEmail());
        String access = this.jwtTokenUtil.generateToken(signedInProfile.getEmail(),
                signedInProfile.getIsAdmin(), signedInProfile.getProfileId());
        String refresh = this.jwtTokenUtil.generateRefreshToken(signedInProfile.getEmail(), signedInProfile.getIsAdmin());

        return new JwtDTO(access, refresh);
    }

    public RefreshDTO refreshAccessToken(RefreshDTO refresh) throws ExpiredRefreshTokenException {
        String access = this.jwtTokenUtil.refreshAccessToken(refresh.getRefreshToken());

        return new RefreshDTO(refresh.getRefreshToken(), access);
    }
}

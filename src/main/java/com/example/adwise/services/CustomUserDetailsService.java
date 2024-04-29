package com.example.adwise.services;

import com.example.adwise.entities.Profile;
import com.example.adwise.repositories.ProfileRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final ProfileRepository profileRepository;

    public CustomUserDetailsService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Profile profile = profileRepository.findByEmail(username);
            String authorization = profile.getIsAdmin() ? "ADMIN" : "USER";

            return User.builder()
                    .username(profile.getEmail())
                    .password(profile.getPassword())
                    .authorities(authorization)
                    .build();
        } catch (Exception e) {

            throw new UsernameNotFoundException("user not found");
        }
    }
}

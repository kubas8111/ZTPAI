package com.example.adwise.loader;

import com.example.adwise.entities.Profile;
import com.example.adwise.repositories.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements CommandLineRunner {
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    public LoadDatabase(ProfileRepository profileRepository, PasswordEncoder passwordEncoder) {
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;
    }

     @Override
     public void run(String... args) throws Exception {
         if(this.profileRepository.findByEmail("admin@admin.com") == null) {
             this.profileRepository.save(new Profile(null, "admin@admin.com", passwordEncoder.encode("admin"), "admin", "mleb", "3433344344", true));
             this.profileRepository.save(new Profile(null, "user@user.com", passwordEncoder.encode("user"), "user", "u", "11234123", false));
         }
     }
}

package com.example.adwise.loader;

import com.example.adwise.entities.Profile;
import com.example.adwise.repositories.ProfileRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

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


//    private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(ProfileRepository profileRepository) {
//
//        return args -> {
//            log.info("Preloading " + profileRepository.save(new Profile(null,"a","a","a","a","a", (short) 0)));
//            log.info("Preloading " + profileRepository.save(new Profile(null,"b","b","b","a2","a", (short) 1)));
//            log.info("Preloading " + profileRepository.save(new Profile(null,"c","c","c","a3","a", (short) 0)));
//            log.info("Preloading " + profileRepository.save(new Profile(null,"d","d","d","a4","a", (short) 0)));
//        };
//    }
}

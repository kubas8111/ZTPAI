package com.example.adwise.loader;

import com.example.adwise.entities.Profile;
import com.example.adwise.repositories.ProfileRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class LoadDatabase {
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

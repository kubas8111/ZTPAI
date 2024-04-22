package com.example.adwise;

import com.example.adwise.entities.Profile;
import com.example.adwise.repositories.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@EntityScan(basePackages = {"com.example.adwise.entities"})
@SpringBootApplication
@RestController
public class AdwiseApplication {

//	private void insertProfiles(ProfileRepository profileRepository) {
//		profileRepository.save(new Profile(null,"a","a","a","a","a", (short) 0));
//		profileRepository.save(new Profile(null,"b","b","b","a2","a", (short) 1));
//		profileRepository.save(new Profile(null,"c","c","c","a3","a", (short) 0));
//		profileRepository.save(new Profile(null,"d","d","d","a4","a", (short) 0));
//	}
//
//	@Bean
//	public CommandLineRunner run(ProfileRepository profileRepository) {
//		return (args) -> {
//			insertProfiles(profileRepository);
//			System.out.println(profileRepository.findAll());
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(AdwiseApplication.class, args);
	}
}

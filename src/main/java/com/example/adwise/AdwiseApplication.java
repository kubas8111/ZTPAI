package com.example.adwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@EntityScan(basePackages = {"com.example.adwise.entities"})
@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdwiseApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdwiseApplication.class, args);
	}
}

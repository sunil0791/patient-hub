package com.straumann.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.straumann")
@EnableMongoRepositories
@EnableCaching
public class PatientContainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientContainerApplication.class, args);
	}

}

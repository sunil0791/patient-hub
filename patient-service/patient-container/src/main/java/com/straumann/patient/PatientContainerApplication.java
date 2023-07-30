package com.straumann.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.straumann")
public class PatientContainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientContainerApplication.class, args);
	}

}

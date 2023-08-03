package com.straumann.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.straumann.patient.domain.PatientDomainService;
import com.straumann.patient.domain.PatientDomainServiceImpl;

@Configuration
public class BeanConfiguration {

	@Bean
	public PatientDomainService orderDomainService() {
		return new PatientDomainServiceImpl();
	}
}

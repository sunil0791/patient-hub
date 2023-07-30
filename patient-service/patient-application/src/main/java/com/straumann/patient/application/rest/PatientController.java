package com.straumann.patient.application.rest;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.straumann.patient.domain.entity.Patient;
import com.straumann.patient.service.domain.ports.input.service.PatientApplicationService;

import jakarta.validation.Valid;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
@RestController
public class PatientController {

	private final PatientApplicationService patientApplicationService;

	public PatientController(PatientApplicationService patientApplicationService) {
		this.patientApplicationService = patientApplicationService;
	}

	@GetMapping("/patients")
	public List<Patient> retrieveAllPatients() {
		return patientApplicationService.getAllPatients();
	}

	@PostMapping("/patients")
	public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
		Patient savedUser = patientApplicationService.createPatient(patient);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/patients/{id}")
	public EntityModel<Patient> retrievePatient(@PathVariable Long id) {
		Patient patient = patientApplicationService.getPatientById(id);
		EntityModel<Patient> entityModel = EntityModel.of(patient);
		WebMvcLinkBuilder link = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllPatients());
		entityModel.add(link.withRel("all-patients"));
		return entityModel;
	}

	@PutMapping("/patients/{id}")
	public EntityModel<Patient> updatePatient(@Valid @RequestBody Patient patient) {
		patientApplicationService.updatePatient(patient);
		EntityModel<Patient> entityModel = EntityModel.of(patient);
		WebMvcLinkBuilder link = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllPatients());
		entityModel.add(link.withRel("all-patients"));
		return entityModel;
	}

	@DeleteMapping("/patients/{id}")
	public void deletePatient(@PathVariable Long id) {
		patientApplicationService.deletePatient(id);
	}

}

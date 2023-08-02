package com.straumann.patient.service.dataaccess.patient.mapper;

import org.springframework.stereotype.Component;

import com.straumann.domain.valueobject.PatientID;
import com.straumann.patient.domain.entity.Patient;
import com.straumann.patient.service.dataaccess.patient.entity.PatientEntity;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
@Component
public class PatientDataAccessMapper {

	public PatientEntity patientToPatientEntity(Patient patient) {
		PatientEntity patientEntity = PatientEntity.builder().id(patient.getId().getValue())
				.firstName(patient.getFirstName()).middleName(patient.getMiddleName()).lastName(patient.getLastName())
				.build();
		return patientEntity;
	}

	public Patient patientEntityToPatient(PatientEntity patientEntity) {
		Patient patient = Patient.builder().firstName(patientEntity.getFirstName())
				.middleName(patientEntity.getMiddleName()).lastName(patientEntity.getLastName()).build();
		patient.setId(new PatientID(patientEntity.getId()));
		return patient;
	}
}

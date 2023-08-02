package com.straumann.patient.service.domain.ports.output.repo;

import java.util.List;
import java.util.Optional;

import com.straumann.domain.valueobject.PatientID;
import com.straumann.patient.domain.entity.Patient;

public interface PatientRepository {

	Patient save(Patient order);

	Optional<Patient> findById(PatientID orderId);

	List<Patient> findAll();

	void delete(PatientID orderId);

}

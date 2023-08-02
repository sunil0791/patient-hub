package com.straumann.patient.service.dataaccess.patient.adapter;

import org.springframework.stereotype.Component;

import com.straumann.domain.valueobject.PatientID;
import com.straumann.patient.domain.entity.Patient;
import com.straumann.patient.service.dataaccess.patient.mapper.PatientDataAccessMapper;
import com.straumann.patient.service.dataaccess.patient.repo.PatientJpaRepository;
import com.straumann.patient.service.domain.ports.output.repo.PatientRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
@Component
public class PatientRepositoryImpl implements PatientRepository {

	private final PatientJpaRepository patientJpaRepository;
	private final PatientDataAccessMapper patientDataAccessMapper;

	public PatientRepositoryImpl(PatientJpaRepository patientJpaRepository,
			PatientDataAccessMapper patientDataAccessMapper) {
		this.patientJpaRepository = patientJpaRepository;
		this.patientDataAccessMapper = patientDataAccessMapper;
	}

	@Override
	public Patient save(Patient patient) {
		return patientDataAccessMapper.patientEntityToPatient(
				patientJpaRepository.save(patientDataAccessMapper.patientToPatientEntity(patient)));
	}

	@Override
	public Optional<Patient> findById(PatientID orderId) {
		return patientJpaRepository.findById(orderId.getValue()).map(patientDataAccessMapper::patientEntityToPatient);
	}

	@Override
	public List<Patient> findAll() {
		return patientJpaRepository.findAll().stream().map(patientDataAccessMapper::patientEntityToPatient).toList();
	}

	@Override
	public void delete(PatientID orderId) {
		patientJpaRepository.deleteAllById(Collections.singletonList(orderId.getValue()));
	}
}

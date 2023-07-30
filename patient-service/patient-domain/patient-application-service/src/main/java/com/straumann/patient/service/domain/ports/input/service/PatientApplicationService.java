/**
 * 
 */
package com.straumann.patient.service.domain.ports.input.service;

import java.util.List;

import com.straumann.patient.domain.entity.Patient;

/**
 * @author Sunil Anjanappa
 *
 */
public interface PatientApplicationService {

	Patient createPatient(Patient patient);

	Patient updatePatient(Patient patient);

	void deletePatient(Long id);

	Patient getPatientById(Long id);

	List<Patient> getAllPatients();
}

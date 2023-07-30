/**
 * 
 */
package com.straumann.patient.service.domain.ports.input.service;

import java.util.List;

import com.straumann.patient.service.domain.dto.PatientDTO;

/**
 * @author Sunil Anjanappa
 *
 */
public interface PatientApplicationService {

	PatientDTO createPatient(PatientDTO patientDTO);

	PatientDTO updatePatient(PatientDTO patientDTO);

	void deletePatient(String id);

	PatientDTO getPatientById(String id);

	List<PatientDTO> getAllPatients();
}

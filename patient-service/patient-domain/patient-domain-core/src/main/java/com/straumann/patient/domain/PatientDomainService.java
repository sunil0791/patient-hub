package com.straumann.patient.domain;

import com.straumann.patient.domain.entity.Patient;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
public interface PatientDomainService {

	Patient validateAndInitiatePatient(Patient patient);

}

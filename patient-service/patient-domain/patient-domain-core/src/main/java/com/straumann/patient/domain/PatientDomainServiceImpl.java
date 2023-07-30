package com.straumann.patient.domain;

import com.straumann.patient.domain.entity.Patient;

/**
 * @author Sunil Anjanappa
 *
 */
public class PatientDomainServiceImpl implements PatientDomainService {
	@Override
	public Patient validateAndInitiatePatient(Patient patient) {
		patient.initializeOrder();
		return patient;
	}

}

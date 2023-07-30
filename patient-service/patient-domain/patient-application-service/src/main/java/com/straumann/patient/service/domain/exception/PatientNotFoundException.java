package com.straumann.patient.service.domain.exception;

import com.straumann.domain.exception.DomainException;

public class PatientNotFoundException extends DomainException {

	public PatientNotFoundException(String message) {
		super(message);
	}

	public PatientNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

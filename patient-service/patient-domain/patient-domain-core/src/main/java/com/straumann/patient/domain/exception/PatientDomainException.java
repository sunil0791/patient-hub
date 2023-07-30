package com.straumann.patient.domain.exception;

import com.straumann.domain.exception.DomainException;

public class PatientDomainException extends DomainException {

	public PatientDomainException(String message) {
		super(message);
	}

	public PatientDomainException(String message, Throwable cause) {
		super(message, cause);
	}
}

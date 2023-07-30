package com.straumann.patient.application.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.straumann.application.handler.ErrorDTO;
import com.straumann.application.handler.GlobalExceptionHandler;
import com.straumann.patient.domain.exception.PatientDomainException;
import com.straumann.patient.service.domain.exception.PatientNotFoundException;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
@Slf4j
@ControllerAdvice
public class PatientGlobalExceptionHandler extends GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = { PatientDomainException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDTO handleException(PatientDomainException patientDomainException) {
		log.error(patientDomainException.getMessage(), patientDomainException);
		return ErrorDTO.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.message(patientDomainException.getMessage()).build();
	}

	@ResponseBody
	@ExceptionHandler(value = { PatientNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDTO handleException(PatientNotFoundException patientNotFoundException) {
		log.error(patientNotFoundException.getMessage(), patientNotFoundException);
		return ErrorDTO.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase())
				.message(patientNotFoundException.getMessage()).build();
	}
}

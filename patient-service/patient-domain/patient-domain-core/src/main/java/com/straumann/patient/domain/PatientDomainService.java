package com.straumann.patient.domain;

import com.straumann.domain.event.publisher.DomainEventPublisher;
import com.straumann.patient.domain.entity.Patient;
import com.straumann.patient.domain.event.PatientCreatedEvent;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
public interface PatientDomainService {

	PatientCreatedEvent validateAndInitiatePatient(Patient patient,
			DomainEventPublisher<PatientCreatedEvent> patientCreatedEventDomainEventPublisher);

}

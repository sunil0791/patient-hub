package com.straumann.patient.domain;

import com.straumann.domain.event.publisher.DomainEventPublisher;
import com.straumann.patient.domain.entity.Patient;
import com.straumann.patient.domain.event.PatientCreatedEvent;

/**
 * @author Sunil Anjanappa
 *
 */
class PatientDomainServiceImpl implements PatientDomainService {
	@Override
	public PatientCreatedEvent validateAndInitiatePatient(Patient order,
			DomainEventPublisher<PatientCreatedEvent> patientCreatedEventDomainEventPublisher) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.straumann.patient.domain.event;

import java.time.ZonedDateTime;

import com.straumann.domain.event.publisher.DomainEventPublisher;
import com.straumann.patient.domain.entity.Patient;

public class PatientCreatedEvent extends PatientEvent {

	private final DomainEventPublisher<PatientCreatedEvent> patientCreatedEventDomainEventPublisher;

	public PatientCreatedEvent(Patient patient, ZonedDateTime createdAt,
			DomainEventPublisher<PatientCreatedEvent> patientCreatedEventDomainEventPublisher) {
		super(patient, createdAt);
		this.patientCreatedEventDomainEventPublisher = patientCreatedEventDomainEventPublisher;
	}

	@Override
	public void fire() {
		patientCreatedEventDomainEventPublisher.publish(this);
	}
}

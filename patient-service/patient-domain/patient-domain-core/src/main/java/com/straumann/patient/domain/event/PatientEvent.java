package com.straumann.patient.domain.event;

import java.time.ZonedDateTime;

import com.straumann.domain.event.DomainEvent;
import com.straumann.patient.domain.entity.Patient;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class PatientEvent implements DomainEvent<Patient> {
	private final Patient patient;
	private final ZonedDateTime createdAt;

}

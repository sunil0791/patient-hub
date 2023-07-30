/**
 * 
 */
package com.straumann.patient.domain.entity;

import java.util.UUID;

import com.straumann.domain.entity.AggregateRoot;
import com.straumann.domain.valueobject.Age;
import com.straumann.domain.valueobject.ContactInformation;
import com.straumann.domain.valueobject.PatientID;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Sunil Anjanappa
 *
 */
@Builder
@Getter
public class Patient extends AggregateRoot<PatientID> {
	private String firstName;
	private String middleName;
	private String lastName;
	private Age age;
	private ContactInformation contactInformation;

	public void initializeOrder() {
		setId(new PatientID(UUID.randomUUID()));
	}

}

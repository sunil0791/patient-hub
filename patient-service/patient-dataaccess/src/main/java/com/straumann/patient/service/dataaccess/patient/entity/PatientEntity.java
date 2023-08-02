package com.straumann.patient.service.dataaccess.patient.entity;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "patient")
@Getter
@Builder
public class PatientEntity {
	@Id
	private UUID id;
	private String firstName;
	private String middleName;
	private String lastName;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PatientEntity that = (PatientEntity) o;
		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

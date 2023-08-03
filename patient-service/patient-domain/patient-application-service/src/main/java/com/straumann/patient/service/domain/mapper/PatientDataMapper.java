package com.straumann.patient.service.domain.mapper;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.straumann.domain.valueobject.Address;
import com.straumann.domain.valueobject.ContactInformation;
import com.straumann.domain.valueobject.PatientID;
import com.straumann.domain.valueobject.PhoneNumber;
import com.straumann.patient.domain.entity.Patient;
import com.straumann.patient.service.domain.dto.PatientDTO;

@Component
public class PatientDataMapper {

	public Patient createPatientDtoToPatient(PatientDTO patientDTO) {
		Optional<String> id = Optional.ofNullable(patientDTO.getId());
		Patient patient = Patient.builder()
				.contactInformation(ContactInformation.builder()
						.address(Address.builder().city(patientDTO.getCity()).country(patientDTO.getCountry())
								.postalCode(patientDTO.getPostalCode()).state(patientDTO.getState())
								.street(patientDTO.getStreet()).build())
						.phoneNumber(PhoneNumber.fromString(patientDTO.getPhoneNumber()))
						.build())
				.firstName(patientDTO.getFirstName()).lastName(patientDTO.getLastName())
				.middleName(patientDTO.getMiddleName()).build();
		if (id.isPresent()) {
			patient.setId(new PatientID(UUID.fromString(id.get())));
		}
		return patient;
	}

	public PatientDTO patientToPatientDto(Patient patient) {
		PhoneNumber phoneNumber = patient.getContactInformation().getPhoneNumber();
		Address address = patient.getContactInformation().getAddress();
		return PatientDTO.builder().phoneNumber(phoneNumber.toString()).firstName(patient.getFirstName())
				.lastName(patient.getLastName()).middleName(patient.getMiddleName()).postalCode(address.getPostalCode())
				.state(address.getState()).street(address.getStreet()).id(patient.getId().getValue().toString())
				.build();
	}
}

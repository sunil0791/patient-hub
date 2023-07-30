/**
 * 
 */
package com.straumann.patient.service.domain.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Sunil Anjanappa
 *
 */
@Builder
@Getter
public class PatientDTO implements Serializable {

	private static final long serialVersionUID = 4554283898245570357L;
	private final String id;
	private final String firstName;
	private final String middleName;
	private final String lastName;
	private final String countryCode;
	private final String areaCode;
	private final String number;
	private final String street;
	private final String city;
	private final String state;
	private final String postalCode;
	private final String country;
}

/**
 * 
 */
package com.straumann.domain.valueobject;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Sunil Anjanappa
 *
 */
@Getter
@Builder
public class ContactInformation {
	private PhoneNumber phoneNumber;
	private Address address;
	// Other fields and methods
}

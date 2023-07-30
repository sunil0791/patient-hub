/**
 * 
 */
package com.straumann.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sunil Anjanappa
 *
 */
@Getter
@AllArgsConstructor
public class ContactInformation {
	private PhoneNumber phoneNumber;
	private Address address;
	// Other fields and methods
}

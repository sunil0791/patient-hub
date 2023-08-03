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
	private final PhoneNumber phoneNumber;
	private final Address address;
	// Other fields and methods
}

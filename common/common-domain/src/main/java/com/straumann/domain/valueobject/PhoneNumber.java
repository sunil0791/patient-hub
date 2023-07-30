package com.straumann.domain.valueobject;

import java.util.Objects;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
@Getter
@Builder
public class PhoneNumber {
	private final String countryCode;
	private final String areaCode;
	private final String number;

	// Factory method to create a PhoneNumber object from a formatted string
	public static PhoneNumber fromString(String formattedPhoneNumber) {
		// Example format: "+1 (555) 123-4567"
		String[] parts = formattedPhoneNumber.split("\\s|\\(|\\)|-");
		if (parts.length == 4) {
			return new PhoneNumber(parts[0], parts[1], parts[2] + parts[3]);
		} else {
			// Handle invalid format, throw an exception, or return null
			throw new IllegalArgumentException("Invalid phone number format: " + formattedPhoneNumber);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber that = (PhoneNumber) o;
		return Objects.equals(countryCode, that.countryCode) && Objects.equals(areaCode, that.areaCode)
				&& Objects.equals(number, that.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryCode, areaCode, number);
	}

	@Override
	public String toString() {
		// Example format: "+1 (555) 123-4567"
		return "+" + countryCode + " (" + areaCode + ") " + number.substring(0, 3) + "-" + number.substring(3);
	}

}

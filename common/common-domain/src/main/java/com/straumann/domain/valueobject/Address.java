/**
 * 
 */
package com.straumann.domain.valueobject;

import java.util.Objects;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Sunil Anjanappa
 *
 */
@Getter
@Builder
public class Address {
	private final String street;
	private final String city;
	private final String state;
	private final String postalCode;
	private final String country;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Address))
			return false;
		Address address = (Address) o;
		return Objects.equals(street, address.street) && Objects.equals(city, address.city)
				&& Objects.equals(state, address.state) && Objects.equals(postalCode, address.postalCode)
				&& Objects.equals(country, address.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(street, city, state, postalCode, country);
	}

	@Override
	public String toString() {
		return street + ", " + city + ", " + state + " " + postalCode + ", " + country;
	}

}

/**
 * 
 */
package com.straumann.domain.valueobject;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sunil Anjanappa
 *
 */
@Getter
@AllArgsConstructor
public class Age {
	private final int years;
	private final int months;

	// Factory method to calculate age from birth date
	public static Age calculateAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(birthDate, currentDate);
		int years = period.getYears();
		int months = period.getMonths();
		return new Age(years, months);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Age))
			return false;
		Age age = (Age) o;
		return years == age.years && months == age.months;
	}

	@Override
	public int hashCode() {
		return Objects.hash(years, months);
	}

	@Override
	public String toString() {
		return years + " years, " + months + " months";
	}
}

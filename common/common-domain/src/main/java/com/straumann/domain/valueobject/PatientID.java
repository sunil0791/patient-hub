package com.straumann.domain.valueobject;

import java.util.UUID;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
public class PatientID extends BaseId<UUID> {
	public PatientID(UUID value) {
		super(value);
	}
}

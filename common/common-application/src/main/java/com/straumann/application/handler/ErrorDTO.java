package com.straumann.application.handler;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
@Data
@Builder
public class ErrorDTO {
	private final String code;
	private final String message;
}

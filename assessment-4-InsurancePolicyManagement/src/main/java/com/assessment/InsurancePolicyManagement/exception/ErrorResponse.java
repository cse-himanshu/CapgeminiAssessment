package com.assessment.InsurancePolicyManagement.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String path;
	public ErrorResponse(LocalDateTime timestamp, int status, String error, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.path = path;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

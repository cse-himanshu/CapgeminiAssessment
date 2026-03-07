package com.assessment.InsurancePolicyManagement.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(Long id) {
		super("Customer not found with ID: " + id);
	}
}

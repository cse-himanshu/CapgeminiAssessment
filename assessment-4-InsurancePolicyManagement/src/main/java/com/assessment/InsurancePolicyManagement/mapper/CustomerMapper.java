package com.assessment.InsurancePolicyManagement.mapper;

import org.springframework.stereotype.Component;

import com.assessment.InsurancePolicyManagement.dto.CustomerRequestDTO;
import com.assessment.InsurancePolicyManagement.dto.CustomerResponseDTO;
import com.assessment.InsurancePolicyManagement.model.Customer;

@Component
public class CustomerMapper {
	public Customer toEntity(CustomerRequestDTO dto) {
		Customer customer = new Customer();
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setPhoneNumber(dto.getPhoneNumber());
		customer.setAddress(dto.getAddress());
		return customer;
	}
	public CustomerResponseDTO toResponseDTO(Customer customer) {
		CustomerResponseDTO dto = new CustomerResponseDTO();
		dto.setId(customer.getId());
		dto.setName(customer.getName());
		dto.setEmail(customer.getEmail());
		dto.setPhoneNumber(customer.getPhoneNumber());
		dto.setAddress(customer.getAddress());
		return dto;
	}
}

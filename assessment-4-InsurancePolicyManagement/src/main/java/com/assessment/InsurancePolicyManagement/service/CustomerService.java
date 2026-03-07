package com.assessment.InsurancePolicyManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.InsurancePolicyManagement.dto.CustomerRequestDTO;
import com.assessment.InsurancePolicyManagement.dto.CustomerResponseDTO;
import com.assessment.InsurancePolicyManagement.exception.CustomerNotFoundException;
import com.assessment.InsurancePolicyManagement.mapper.CustomerMapper;
import com.assessment.InsurancePolicyManagement.model.Customer;
import com.assessment.InsurancePolicyManagement.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	private CustomerRepository customerRepository;

	private CustomerMapper customerMapper;
	
	public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
		Customer customer = customerMapper.toEntity(dto);
		Customer saved = customerRepository.save(customer);
		return customerMapper.toResponseDTO(saved);
	}

	@Transactional(readOnly = true)
	public List<CustomerResponseDTO> getAllCustomers() {
		return customerRepository.findAll().stream()
				.map(customerMapper::toResponseDTO)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CustomerResponseDTO getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
		return customerMapper.toResponseDTO(customer);
	}
}

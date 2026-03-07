package com.assessment.InsurancePolicyManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.InsurancePolicyManagement.dto.PolicyRequestDTO;
import com.assessment.InsurancePolicyManagement.dto.PolicyResponseDTO;
import com.assessment.InsurancePolicyManagement.exception.CustomerNotFoundException;
import com.assessment.InsurancePolicyManagement.exception.PolicyNotFoundException;
import com.assessment.InsurancePolicyManagement.mapper.PolicyMapper;
import com.assessment.InsurancePolicyManagement.model.Customer;
import com.assessment.InsurancePolicyManagement.model.Policy;
import com.assessment.InsurancePolicyManagement.model.Status;
import com.assessment.InsurancePolicyManagement.repository.CustomerRepository;
import com.assessment.InsurancePolicyManagement.repository.PolicyRepository;

@Service
@Transactional
public class PolicyService {
	private PolicyRepository policyRepository;

	private CustomerRepository customerRepository;

	private PolicyMapper policyMapper;
	
	public PolicyService(PolicyRepository policyRepository, CustomerRepository customerRepository, PolicyMapper policyMapper) {
		this.policyMapper = policyMapper;
		this.customerRepository = customerRepository;
		this.policyRepository = policyRepository;
	}

	public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
		Customer customer = customerRepository.findById(dto.getCustomerId())
				.orElseThrow(() -> new CustomerNotFoundException(dto.getCustomerId()));
		Policy policy = policyMapper.toEntity(dto, customer);
		Policy saved = policyRepository.save(policy);
		return policyMapper.toResponseDTO(saved);
	}

	@Transactional(readOnly = true)
	public Page<PolicyResponseDTO> getAllPolicies(Pageable pageable) {
		return policyRepository.findAll(pageable)
				.map(policyMapper::toResponseDTO);
	}

	@Transactional(readOnly = true)
	public PolicyResponseDTO getPolicyById(Long id) {
		Policy policy = policyRepository.findById(id)
				.orElseThrow(() -> new PolicyNotFoundException(id));
		return policyMapper.toResponseDTO(policy);
	}

	public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {
		Policy policy = policyRepository.findById(id)
				.orElseThrow(() -> new PolicyNotFoundException(id));
		policy.setPolicyNumber(dto.getPolicyNumber());
		policy.setPolicyType(dto.getPolicyType());
		policy.setPremiumAmount(dto.getPremiumAmount());
		policy.setCoverageAmount(dto.getCoverageAmount());
		policy.setStartDate(dto.getStartDate());
		policy.setEndDate(dto.getEndDate());
		if (dto.getCustomerId() != null) {
			Customer customer = customerRepository.findById(dto.getCustomerId())
					.orElseThrow(() -> new CustomerNotFoundException(dto.getCustomerId()));
			policy.setCustomer(customer);
		}
		Policy updated = policyRepository.save(policy);
		return policyMapper.toResponseDTO(updated);
	}

	public void cancelPolicy(Long id) {
		Policy policy = policyRepository.findById(id)
				.orElseThrow(() -> new PolicyNotFoundException(id));
		policy.setStatus(Status.CANCELLED);
		policyRepository.save(policy);
	}

	@Transactional(readOnly = true)
	public List<PolicyResponseDTO> getPoliciesByType(String policyType) {
		return policyRepository.findByPolicyType(policyType).stream()
				.map(policyMapper::toResponseDTO)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<PolicyResponseDTO> getPoliciesByPremiumRange(Double min, Double max) {
		return policyRepository.findByPremiumAmountBetween(min, max).stream()
				.map(policyMapper::toResponseDTO)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<PolicyResponseDTO> getPoliciesByCustomerEmail(String email) {
		return policyRepository.findByCustomerEmail(email).stream()
				.map(policyMapper::toResponseDTO)
				.collect(Collectors.toList());
	}
}

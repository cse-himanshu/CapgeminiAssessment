package com.assessment.InsurancePolicyManagement.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assessment.InsurancePolicyManagement.dto.PolicyRequestDTO;
import com.assessment.InsurancePolicyManagement.dto.PolicyResponseDTO;
import com.assessment.InsurancePolicyManagement.model.Customer;
import com.assessment.InsurancePolicyManagement.model.Policy;
import com.assessment.InsurancePolicyManagement.model.Status;

@Component
public class PolicyMapper {

	@Autowired
	private CustomerMapper customerMapper;

	public Policy toEntity(PolicyRequestDTO dto, Customer customer) {
		Policy policy = new Policy();
		policy.setPolicyNumber(dto.getPolicyNumber());
		policy.setPolicyType(dto.getPolicyType());
		policy.setPremiumAmount(dto.getPremiumAmount());
		policy.setCoverageAmount(dto.getCoverageAmount());
		policy.setStartDate(dto.getStartDate());
		policy.setEndDate(dto.getEndDate());
		policy.setStatus(Status.ACTIVE);
		policy.setCustomer(customer);
		return policy;
	}

	public PolicyResponseDTO toResponseDTO(Policy policy) {
		PolicyResponseDTO dto = new PolicyResponseDTO();
		dto.setId(policy.getId());
		dto.setPolicyNumber(policy.getPolicyNumber());
		dto.setPolicyType(policy.getPolicyType());
		dto.setPremiumAmount(policy.getPremiumAmount());
		dto.setCoverageAmount(policy.getCoverageAmount());
		dto.setStartDate(policy.getStartDate());
		dto.setEndDate(policy.getEndDate());
		dto.setStatus(policy.getStatus());
		dto.setCustomer(customerMapper.toResponseDTO(policy.getCustomer()));
		return dto;
	}
}

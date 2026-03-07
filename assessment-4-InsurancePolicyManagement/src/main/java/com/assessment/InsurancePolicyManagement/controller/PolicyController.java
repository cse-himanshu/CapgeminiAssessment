package com.assessment.InsurancePolicyManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.InsurancePolicyManagement.dto.PolicyRequestDTO;
import com.assessment.InsurancePolicyManagement.dto.PolicyResponseDTO;
import com.assessment.InsurancePolicyManagement.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

	private PolicyService policyService;
	
	public PolicyController(PolicyService policyService) {
		this.policyService = policyService;
	}
	
	@PostMapping
	public ResponseEntity<PolicyResponseDTO> createPolicy(@Valid @RequestBody PolicyRequestDTO dto) {
		PolicyResponseDTO response = policyService.createPolicy(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<Page<PolicyResponseDTO>> getAllPolicies(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String direction) {
		Sort sort = direction.equalsIgnoreCase("desc")
				? Sort.by(sortBy).descending()
				: Sort.by(sortBy).ascending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return ResponseEntity.ok(policyService.getAllPolicies(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable Long id) {
		return ResponseEntity.ok(policyService.getPolicyById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PolicyResponseDTO> updatePolicy(@PathVariable Long id,
			@Valid @RequestBody PolicyRequestDTO dto) {
		return ResponseEntity.ok(policyService.updatePolicy(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancelPolicy(@PathVariable Long id) {
		policyService.cancelPolicy(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/type/{type}")
	public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByType(@PathVariable String type) {
		return ResponseEntity.ok(policyService.getPoliciesByType(type));
	}

	@GetMapping("/premium")
	public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByPremiumRange(
			@RequestParam Double min,
			@RequestParam Double max) {
		return ResponseEntity.ok(policyService.getPoliciesByPremiumRange(min, max));
	}
}

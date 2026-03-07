package com.assessment.InsurancePolicyManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.InsurancePolicyManagement.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}

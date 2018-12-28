package com.mybank.bankapi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCustomerId(@Param("customerId") String customerId);

}

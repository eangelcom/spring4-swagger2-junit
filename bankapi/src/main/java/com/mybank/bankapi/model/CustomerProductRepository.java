package com.mybank.bankapi.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long> {

	CustomerProduct findByCustomerIdAndProductNumber(@Param("customerId") Long customerId, @Param("productNumber") String productNumber);

	List<CustomerProduct> findByCustomerId(@Param("customerId") Long customerId);

}

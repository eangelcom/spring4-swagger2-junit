package com.mybank.bankapi.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query(value="SELECT t.* FROM transaction t JOIN customer_product cp ON t.customer_product_id = cp.id WHERE cp.customer_id=:customerId AND cp.product_number=:productNumber ORDER BY t.date DESC LIMIT :limit", nativeQuery = true)
	List<Transaction> findByCustomerIdAndProductNumber(@Param("limit") Integer limit, @Param("customerId") String customerId, @Param("productNumber") String productNumber);

}

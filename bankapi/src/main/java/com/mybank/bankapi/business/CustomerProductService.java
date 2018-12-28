package com.mybank.bankapi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybank.bankapi.model.CustomerProduct;
import com.mybank.bankapi.model.CustomerProductRepository;

@Service
public class CustomerProductService {
	
	private final CustomerProductRepository customerProductRepository;
	
	public CustomerProductService(CustomerProductRepository customerProductRepository) {
		this.customerProductRepository = customerProductRepository;
	}

	public CustomerProduct findByCustomerIdAndProductNumber(Long customerId, String productNumber) {
		return customerProductRepository.findByCustomerIdAndProductNumber(customerId, productNumber);
	}

	public List<CustomerProduct> findByCustomerId(Long customerId) {
		return customerProductRepository.findByCustomerId(customerId);
	}

	public CustomerProduct createCustomerProduct(CustomerProduct customerProduct) {
		return customerProductRepository.save(customerProduct);
	}

	public List<CustomerProduct> findAll() {
		return customerProductRepository.findAll();
	}
	
}

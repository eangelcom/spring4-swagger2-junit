package com.mybank.bankapi.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bankapi.business.CustomerProductService;
import com.mybank.bankapi.model.CustomerProduct;
import com.mybank.bankapi.web.util.HttpUtil;

@RestController
@RequestMapping("/product")
public class CustomerProductController {
	
	private final CustomerProductService customerProductService;
	
	public CustomerProductController(CustomerProductService customerProductService) {
		this.customerProductService = customerProductService;
	}

	@GetMapping("/{customerId}/{productNumber}/get")
	public CustomerProduct findByCustomerIdAndProductNumber(@PathVariable Long customerId, @PathVariable String productNumber) {
		return customerProductService.findByCustomerIdAndProductNumber(customerId, productNumber);		
	}

	@GetMapping("/{customerId}/get")
	public List<CustomerProduct> findByCustomerId(@PathVariable Long customerId) {
		return customerProductService.findByCustomerId(customerId);
	}	
	
	@PostMapping("/createCustomerProduct")
	public ResponseEntity<?> createCustomerProduct(@RequestBody CustomerProduct customerProduct) {
		customerProduct = customerProductService.createCustomerProduct(customerProduct);
		return HttpUtil.successResponse(customerProduct.getId()+"");
	}
	
	@GetMapping("/get")
	public List<CustomerProduct> findAll() {
		return customerProductService.findAll();
	}
	
}

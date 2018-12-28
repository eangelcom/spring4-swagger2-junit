package com.mybank.bankapi.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bankapi.business.CustomerService;
import com.mybank.bankapi.model.Customer;
import com.mybank.bankapi.web.dto.LoginRequestDto;
import com.mybank.bankapi.web.util.HttpUtil;
import com.mybank.bankapi.web.util.ParseUtil;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signup(@RequestBody Customer customer) throws Exception {
		customer.setPassword(ParseUtil.passwordEncrypt(customer.getPassword()));		
		customerService.signup(customer);
	    return HttpUtil.successResponse("Customer created successfully");		
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
		Customer customer = customerService.login(loginRequestDto.getCustomerId());
		String token = customerService.authenticate(loginRequestDto, customer); 
		return HttpUtil.authorizedResponse(token);
	}
	
	@GetMapping("/{customerId}/get")
	public Customer findByCustomerId(@PathVariable String customerId) {
		return customerService.findByCustomerId(customerId);		
	}
	
}

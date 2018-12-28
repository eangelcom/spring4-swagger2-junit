package com.mybank.bankapi.business;

import org.springframework.stereotype.Service;

import com.mybank.bankapi.business.exception.UnauthorizedException;
import com.mybank.bankapi.model.Customer;
import com.mybank.bankapi.model.CustomerRepository;
import com.mybank.bankapi.web.dto.LoginRequestDto;
import com.mybank.bankapi.web.util.ParseUtil;

@Service
public class CustomerService {
	
	private static final String MASKED_PASSWORD = "******";

	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer signup(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer login(String customerId) {
		return customerRepository.findByCustomerId(customerId);
	}

	public String authenticate(LoginRequestDto loginRequestDto, Customer customer) {
		if(customer==null) {
			throw new UnauthorizedException();
		}
		if(!ParseUtil.passwordMatches(loginRequestDto.getPassword(), customer.getPassword())) {
			throw new UnauthorizedException();
		}
		return "dummy"; //TODO create and persist token
	}

	public Customer findByCustomerId(String customerId) {
		Customer customer =  customerRepository.findByCustomerId(customerId);
		if(null!=customer) {
			customer.setPassword(MASKED_PASSWORD);			
		}
		return customer;
	}
	
}

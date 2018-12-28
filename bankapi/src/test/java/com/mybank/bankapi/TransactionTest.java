package com.mybank.bankapi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mybank.bankapi.model.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TransactionTest {
	
	private static final String API_URI = "/transaction";
	
	@Autowired
	private TestRestTemplate trt;	
	
	@Test
	public void returnCreatedStatusWhenSave() {
		
		ResponseEntity<String> result = trt.postForEntity(API_URI+"/save", getTransactionRequest(1L), String.class);		
		Assert.assertEquals(HttpStatus.CREATED.value(), result.getStatusCodeValue());
	}
	
	private HttpEntity<Transaction> getTransactionRequest(Long customerProductId) {
		Transaction req = new Transaction();	
		req.setCustomerProductId(customerProductId);
		return new HttpEntity<>(req, new HttpHeaders());
	}
	
}

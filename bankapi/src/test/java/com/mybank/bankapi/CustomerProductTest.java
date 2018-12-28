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

import com.mybank.bankapi.model.CustomerProduct;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerProductTest {

	private static final String API_URI = "/product";
	
	@Autowired
	private TestRestTemplate trt;	
	
	@Test
	public void returnSuccessStatusWhenCreateCustomerProduct() {
		
		ResponseEntity<String> result = trt.postForEntity(API_URI+"/createCustomerProduct", getCustomerProductRequest("1000000001",1L, 1L), String.class);		
		Assert.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
	}
	
	private HttpEntity<CustomerProduct> getCustomerProductRequest(String productNumber, Long customerId, Long productId) {
		CustomerProduct req = new CustomerProduct();
		req.setProductNumber(productNumber);	
		req.setCustomerId(customerId);
		req.setProductId(productId);
		return new HttpEntity<>(req, new HttpHeaders());
	}
	
	@Test
	public void returnSuccessStatusWhenFindByCustomerId() {
		
		ResponseEntity<String> result = trt.postForEntity(API_URI+"/createCustomerProduct", getCustomerProductRequest("1000000001",1L, 1L), String.class);		
		Assert.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
		
		ResponseEntity<String> result2 = trt.getForEntity(API_URI+"/1/get", String.class);
		Assert.assertEquals(HttpStatus.OK.value(), result2.getStatusCodeValue());
	}
	
	@Test
	public void returnSuccessStatusWhenFindByCustomerIdAndProductNumber() {
		
		ResponseEntity<String> result = trt.postForEntity(API_URI+"/createCustomerProduct", getCustomerProductRequest("1000000001",1L, 1L), String.class);		
		Assert.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
		
		ResponseEntity<String> result2 = trt.getForEntity(API_URI+"/1/1/get", String.class);
		Assert.assertEquals(HttpStatus.OK.value(), result2.getStatusCodeValue());
	}
	
}

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

import com.mybank.bankapi.model.Customer;
import com.mybank.bankapi.web.dto.LoginRequestDto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerTests {
	
	private static final String API_URI = "/customer";
	
	@Autowired
	private TestRestTemplate trt;	

	@Test
	public void returnSuccessStatusWhenSignupAndLogin() {
		
		ResponseEntity<String> result = trt.postForEntity(API_URI+"/sign-up", getSignUpRequest("123","mypassword"), String.class);		
		Assert.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
		
		ResponseEntity<String> result2 = trt.postForEntity(API_URI+"/login", getLoginRequest("123","mypassword"), String.class);		
		Assert.assertEquals(HttpStatus.OK.value(), result2.getStatusCodeValue());
	}

	@Test
	public void returnUnauthorizedStatusWhenLoginFails() {
		ResponseEntity<String> result2 = trt.postForEntity(API_URI+"/login", getLoginRequest("123",""), String.class);		
		Assert.assertEquals(HttpStatus.UNAUTHORIZED.value(), result2.getStatusCodeValue());
	}
	
	private HttpEntity<Customer> getSignUpRequest(String customerId, String password) {
		Customer req = new Customer();
		req.setCustomerId(customerId);
		req.setPassword(password);
		return new HttpEntity<>(req, new HttpHeaders());
	}

	private HttpEntity<LoginRequestDto> getLoginRequest(String customerId, String password) {
		LoginRequestDto req = new LoginRequestDto();
		req.setCustomerId(customerId);
		req.setPassword(password);
		return new HttpEntity<>(req, new HttpHeaders());
	}

	@Test
	public void returnSuccessStatusWhenFindByCustomerId() {
		
		ResponseEntity<String> result = trt.postForEntity(API_URI+"/sign-up", getSignUpRequest("321","mypassword"), String.class);		
		Assert.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
		
		ResponseEntity<String> result2 = trt.getForEntity(API_URI+"/321/get", String.class);
		Assert.assertEquals(HttpStatus.OK.value(), result2.getStatusCodeValue());
	}

	@Test
	public void testHome() throws Exception {

		String swagger = trt.getForObject("/v2/api-docs", String.class);

		writeFile("swagger.json", swagger );
	}

	private void writeFile(String fileName, String content) {

		File theDir = new File("swagger");

		if (!theDir.exists()) {
			try{
				theDir.mkdir();
			}
			catch(SecurityException se){ }
		}

		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("../"+fileName);
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

	}

}


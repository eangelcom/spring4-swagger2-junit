package com.mybank.bankapi.web.dto;

public class LoginRequestDto {
	
	private String customerId;
	private String password;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
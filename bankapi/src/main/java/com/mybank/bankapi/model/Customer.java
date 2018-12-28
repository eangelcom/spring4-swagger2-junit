package com.mybank.bankapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	private @Id @GeneratedValue Long id;
	
	private  @Column(name="name") String name;
	private  @Column(name="surname") String surname;
	private  @Column(name="customer_id") String customerId;
	private  @Column(name="email") String email;
	private  @Column(name="mobile") String mobile;
	private  @Column(name="phone") String phone;
	private  @Column(name="password") String password;
	
	public Customer() {
		
	}
	
	public Customer(String customerId, String password) {
		this.customerId = customerId;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

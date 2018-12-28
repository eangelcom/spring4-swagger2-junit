package com.mybank.bankapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="customer_product")
public class CustomerProduct {

	private @Id @GeneratedValue Long id;

	private  @Column(name="creation_date") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date creationDate;
	private  @Column(name="termination_date") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date terminationDate;
	private  @Column(name="balance") Long balance;
	private  @Column(name="status") String status;
	private  @Column(name="product_number") String productNumber;
	
	private  @Column(name="customer_id") Long customerId;
	private  @Column(name="product_id") Long productId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}

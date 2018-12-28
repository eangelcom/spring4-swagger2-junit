package com.mybank.bankapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="transaction")
public class Transaction {
	
	private @Id @GeneratedValue Long id;
	
	private @Column(name="channel_id") Long channelId;
	private  @Column(name="amount") Long amount;
	private  @Column(name="date") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date;
	private  @Column(name="status") String status;
	private  @Column(name="type") Long transactionType;
	private  @Column(name="transaction_number") Long transactionNumber;
	
	private  @Column(name="customer_product_id") Long customerProductId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(Long transactionType) {
		this.transactionType = transactionType;
	}
	public Long getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(Long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Long getCustomerProductId() {
		return customerProductId;
	}
	public void setCustomerProductId(Long customerProductId) {
		this.customerProductId = customerProductId;
	}

}

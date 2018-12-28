package com.mybank.bankapi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybank.bankapi.business.exception.CustomerProductNotFoundException;
import com.mybank.bankapi.model.Transaction;
import com.mybank.bankapi.model.TransactionRepository;

@Service
public class TransactionService {
	
	private final TransactionRepository transactionRepository;
	
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public Transaction save(Transaction transaction) {
		if (transaction.getCustomerProductId() == null) {
			throw new CustomerProductNotFoundException();
		}
		return transactionRepository.save(transaction);
	}

	public List<Transaction> findLastTransactions(Integer limit, String customerProductId, String productNumber) {
		return transactionRepository.findByCustomerIdAndProductNumber(limit, customerProductId, productNumber);
	}
	
}

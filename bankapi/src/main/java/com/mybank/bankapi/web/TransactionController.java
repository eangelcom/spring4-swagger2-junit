package com.mybank.bankapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bankapi.business.TransactionService;
import com.mybank.bankapi.model.Transaction;
import com.mybank.bankapi.web.util.HttpUtil;
import com.mybank.bankapi.web.util.ParseUtil;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	private final TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping("/save")
	public  ResponseEntity<?> save(@Valid @RequestBody Transaction transaction) throws Exception {
		transaction = transactionService.save(transaction);	
	    return HttpUtil.createdResponse(ParseUtil.toJson(transaction));
	}

	@GetMapping("/getLast/{limit}/{customerProductId}/{productNumber}")
	public List<Transaction> findLastTransactions(@PathVariable Integer limit,@PathVariable String customerProductId,@PathVariable String productNumber) {
		return transactionService.findLastTransactions(limit, customerProductId, productNumber);
	}	
}

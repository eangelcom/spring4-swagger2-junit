package com.mybank.bankapi.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Customer product not found")  // 404
public class CustomerProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}

package com.mybank.bankapi.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Authentication Failed: Bad credentials")  // 401
public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}

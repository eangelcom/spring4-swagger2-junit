package com.mybank.bankapi.web.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpUtil {

	public static ResponseEntity<Map<String, Object>> successResponse(String responseMessage){
	    Map<String, Object> json = new HashMap<String, Object>();
	    json.put("status", successStatus());
	    json.put("response", responseMessage);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=UTF-8");
	    return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
	}
	
	private static Map<String, Object> successStatus() {
		Map<String, Object> status = new HashMap<String, Object>();
	    status.put("status_code", 0);
	    status.put("status_desc", "SUCCESS");		
		return status;
	}

	public static ResponseEntity<?> authorizedResponse(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("authorization", token);
		return (new ResponseEntity<Map<String, Object>>(null, headers, HttpStatus.OK));
	}

	public static ResponseEntity<?> createdResponse(String detail) {
	    Map<String, Object> json = new HashMap<String, Object>();
	    json.put("message", "success");
	    json.put("detail", detail);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=UTF-8");
	    return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.CREATED));
	}
	
}

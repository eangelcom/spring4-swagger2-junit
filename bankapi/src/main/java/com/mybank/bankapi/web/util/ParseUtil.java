package com.mybank.bankapi.web.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseUtil {
	
	public static String toJson(Object object) throws JsonProcessingException {
		return (new ObjectMapper().writer().withDefaultPrettyPrinter()).writeValueAsString(object);
	}
	
	public static String passwordEncrypt(String password) {
		return (new BCryptPasswordEncoder()).encode(password);
	}
	
	public static boolean passwordMatches(String password, String cryptedPassword) {
		return (new BCryptPasswordEncoder()).matches(password, cryptedPassword);
	}
}

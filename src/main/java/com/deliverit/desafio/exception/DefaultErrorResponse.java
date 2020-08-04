package com.deliverit.desafio.exception;

import org.springframework.http.HttpStatus;

public class DefaultErrorResponse {

	private HttpStatus code;
	private String message; 

	public DefaultErrorResponse(HttpStatus code, String message) {
		this.code = code;
		this.message = message;
	}

	public HttpStatus getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}

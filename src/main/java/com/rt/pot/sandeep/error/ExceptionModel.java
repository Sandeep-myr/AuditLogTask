package com.rt.pot.sandeep.error;

import org.springframework.http.HttpStatus;

public class ExceptionModel {

	
	private String message;
	
	private HttpStatus httpStatus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}

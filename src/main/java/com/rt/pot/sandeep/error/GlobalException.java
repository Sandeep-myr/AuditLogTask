package com.rt.pot.sandeep.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class GlobalException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	
	
	
	public GlobalException( String message, Throwable cause) {
		super();
		
	}
	
	

	
}

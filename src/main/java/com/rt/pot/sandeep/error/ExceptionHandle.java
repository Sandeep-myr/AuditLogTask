package com.rt.pot.sandeep.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<ExceptionModel> unkownExceptionHandler(Exception e){
		ExceptionModel exceptionModel = new ExceptionModel();
		exceptionModel.setHttpStatus(HttpStatus.BAD_REQUEST);
		exceptionModel.setMessage(e.getMessage());
		return new ResponseEntity<>(exceptionModel,HttpStatus.BAD_REQUEST); 
	}
	
	

}

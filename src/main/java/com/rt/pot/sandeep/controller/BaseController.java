package com.rt.pot.sandeep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.rt.pot.sandeep.response.Response;

@RestController
public abstract class BaseController {
	

	public ResponseEntity<Response> getOKResponseEntity(Response response) {
		return  new ResponseEntity<Response>(response,HttpStatus.OK);
	}

	
	
//	public ResponseEntity<Response> getOKResponseEntity(String message) {
//		return new ResponseEntity<>(new Response(Constants.OK, message, null), HttpStatus.OK);
//	}
	
	
	
}

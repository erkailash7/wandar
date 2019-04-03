package com.wander.wander.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class WanderExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<WanderErrorResponse> handleException(WanderException exception){
		WanderErrorResponse  c = new WanderErrorResponse();
		c.setMessage(exception.getMessage());
		c.setStatus(HttpStatus.NOT_FOUND.value());
		c.setTimeStump(System.currentTimeMillis());
		return new ResponseEntity<>(c, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<WanderErrorResponse> handleException(Exception e){
		WanderErrorResponse c = new WanderErrorResponse();
		c.setMessage(e.getMessage());
		c.setStatus(HttpStatus.BAD_REQUEST.value());
		c.setTimeStump(System.currentTimeMillis());
		return new ResponseEntity<>(c, HttpStatus.BAD_REQUEST);
		
	}

}

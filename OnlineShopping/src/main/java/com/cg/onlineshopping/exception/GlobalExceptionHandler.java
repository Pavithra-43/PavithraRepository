package com.cg.onlineshopping.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ExceptionDetails> productNotFoundException(ProductIdNotFoundException ex, WebRequest request)
	{
		ExceptionDetails details=new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ExceptionDetails> customerNotFoundException(InvalidUserException ex, WebRequest request)
	{
		ExceptionDetails details=new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OSException.class)
	public ResponseEntity<ExceptionDetails> otherException(OSException ex, WebRequest request)
	{
		ExceptionDetails details=new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}

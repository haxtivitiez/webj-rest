package com.anuwk.webjrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentResExceptionHandler {
	

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlException(StudentNotFoundException e){
		StudentErrorResponse eser = new StudentErrorResponse();
		eser.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
		eser.setMessage(e.getMessage());
		eser.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(eser,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlException(Exception e){
		StudentErrorResponse eser = new StudentErrorResponse();
		eser.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		eser.setMessage(e.getMessage());
		eser.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(eser,HttpStatus.BAD_REQUEST);
	}
	
	
	

}

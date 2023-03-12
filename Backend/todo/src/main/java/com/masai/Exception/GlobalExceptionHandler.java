package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(Exception ce, WebRequest req){
		
		
		ErrorDetails err= new ErrorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(ce.getMessage());
			err.setDescription(req.getDescription(false));
				
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}

    
}

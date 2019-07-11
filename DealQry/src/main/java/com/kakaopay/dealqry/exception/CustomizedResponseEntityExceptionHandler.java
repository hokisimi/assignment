package com.kakaopay.dealqry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(DealNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(DealNotFoundException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails("404", "br code not found error");
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
}

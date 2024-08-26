package com.app.product.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Object> handleCustomException(ProductException exception) {
		APIError error = new APIError(HttpStatus.BAD_REQUEST.value(), exception.getErrorResponses(),
				exception.getMessage(), null);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
		APIError error = new APIError(HttpStatus.BAD_REQUEST.value(), new ArrayList<>(), exception.getMessage(), null);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception exception) {
		APIError error = new APIError(HttpStatus.BAD_REQUEST.value(), new ArrayList<>(), exception.getMessage(), null);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}

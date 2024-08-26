package com.app.product.exception;

import java.util.ArrayList;
import java.util.List;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<ErrorResponse> errorResponses = new ArrayList<>();

	public ProductException() {
		super();
	}

	public ProductException(String message) {
		super(message);
	}

	public ProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductException(ErrorResponse errorResponse) {
		this();
		addErrorResponse(errorResponse);
	}

	public ProductException(String message, ErrorResponse errorResponse) {
		super(message);
		addErrorResponse(errorResponse);
	}

	public void addErrorResponse(ErrorResponse errorResponse) {
		errorResponses.add(errorResponse);
	}

	public List<ErrorResponse> getErrorResponses() {
		return errorResponses;
	}

}

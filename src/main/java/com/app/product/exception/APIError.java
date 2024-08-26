package com.app.product.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class APIError {
	private int statusCode;
	private String message;
	List<ErrorResponse> response = new ArrayList<>();
	private String stackTrace;
	List<ErrorResponse> errorResponse = new ArrayList<>();
	private String requestId;

	public APIError(int status, List<ErrorResponse> error, String message, String stackTrace) {
		this.statusCode = status;
		this.errorResponse = error;
		this.message = message;
		this.stackTrace = stackTrace;
	}
}

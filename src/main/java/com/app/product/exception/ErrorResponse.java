package com.app.product.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	public static final int BAD_REQUEST = 400;
	public static final int NOT_FOUND = 404;
	public static final int DUPLICATE = 409;
	public static final int STOAGE_EXCEEDED = 413;
	public static final int INTERNAL_SERVER_ERROR = 500;

	private int errorCode;
	private String errorMessage;
	private String onField;
	private Object value;

	public ErrorResponse(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ErrorResponse(int errorCode, String errorMessage, String onField) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.onField = onField;
	}

	public ErrorResponse(int errorCode, String errorMessage, Object value) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.value = value;
	}

	public ErrorResponse(int errorCode, String errorMessage, String onField, Object value) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.onField = onField;
		this.value = value;
	}
}

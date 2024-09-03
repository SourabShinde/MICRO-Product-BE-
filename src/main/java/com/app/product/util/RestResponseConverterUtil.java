package com.app.product.util;

public class RestResponseConverterUtil {

    public static <T> ResponseEntity<T> success(T response) {
	return new ResponseEntity<T>(response);
    }

    public static <T> ResponseEntity<T> success(String statusCode, String message, T response) {
	return new ResponseEntity<T>(statusCode, message, response);
    }

}

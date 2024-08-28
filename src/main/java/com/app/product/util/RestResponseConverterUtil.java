package com.app.product.util;

public class RestResponseConverterUtil {
	
	public static <T> ResponseEntity<T> success(T response){
		return new ResponseEntity<T>(response);
	}

}

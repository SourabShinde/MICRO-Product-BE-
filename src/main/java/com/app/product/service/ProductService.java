package com.app.product.service;

import org.springframework.stereotype.Service;

import com.app.product.dto.ProductDto;

@Service
public interface ProductService {

	public Object createProduct(ProductDto productDto);

}

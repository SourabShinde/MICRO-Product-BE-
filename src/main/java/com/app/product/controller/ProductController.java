package com.app.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.constants.APIConstants;
import com.app.product.constants.APIConstants.CommonAPIConstants;
import com.app.product.dto.ProductDto;
import com.app.product.service.ProductService;
import com.app.product.util.ResponseEntity;
import com.app.product.util.RestResponseConverterUtil;

@RestController
@RequestMapping(APIConstants.PRODUCT)
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(CommonAPIConstants.CREATE)
	public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
		return RestResponseConverterUtil.success(productService.createProduct(productDto));
	}

}

package com.app.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.constants.APIConstants;
import com.app.product.constants.APIConstants.CommonAPIConstants;
import com.app.product.constants.APIConstants.HeaderConstants;
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
    public ResponseEntity<?> createProduct(@RequestHeader(HeaderConstants.USER_ID) int userId,
	    @RequestBody ProductDto productReq) {
	return RestResponseConverterUtil.success(productService.createProduct(userId, productReq));
    }

    @GetMapping(CommonAPIConstants.GET + CommonAPIConstants.ALL)
    public ResponseEntity<?> getAllProducts(@RequestHeader(HeaderConstants.USER_ID) int userId) {
	return RestResponseConverterUtil.success(productService.fetchAllProducts(userId));
    }

}

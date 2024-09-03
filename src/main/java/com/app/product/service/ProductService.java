package com.app.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.product.dto.ProductDto;

@Service
public interface ProductService {

    public Object createProduct(int userId, ProductDto productReq);

    public List<ProductDto> fetchAllProducts(int userId);

}

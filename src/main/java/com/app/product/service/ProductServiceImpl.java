package com.app.product.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.product.constants.ProductConstants;
import com.app.product.dto.ProductDto;
import com.app.product.exception.ErrorResponse;
import com.app.product.exception.ProductException;
import com.app.product.model.Product;
import com.app.product.repository.ProductRepository;
import com.app.product.util.Utilities;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Object createProduct(int userId, ProductDto productDto) {
	log.info("In create Product method() from class {} :: {}", ProductServiceImpl.class, new Date());
	validateProduct(userId, productDto);
	Product product = mapper.map(productDto, Product.class);
	Utilities.setAuditFields(userId, product, false);
	productRepo.save(product);
	log.info("Product {} saved successfully. at {}", product.getName(), new Date());
	return "Product " + product.getName() + " added successfully.";
    }

    private void validateProduct(int userId, ProductDto productDto) {
	log.info("In Validate Product method() from class " + ProductServiceImpl.class + " :: " + new Date());
	Utilities.commonValidation(userId);
	if (!Utilities.isNotBlank(productDto.getName())) {
	    throw new ProductException("Product name is mandatory.",
		    new ErrorResponse(ErrorResponse.NOT_FOUND, "Product name is mandatory."));
	}

	if (productRepo.existsByName(productDto.getName())) {
	    throw new ProductException("Duplicate product.",
		    new ErrorResponse(ErrorResponse.DUPLICATE, "Duplicate product."));
	}

	if (productDto.getDescription().length() > ProductConstants.HUNDRED) {
	    throw new ProductException("Description should be 100 words max.",
		    new ErrorResponse(ErrorResponse.BAD_REQUEST, "Description should be 100 words max."));
	}
    }

    @Override
    public List<ProductDto> fetchAllProducts(int userId) {
	log.info("In fetch all products method from class {} :: {}", ProductServiceImpl.class, new Date());
	Utilities.commonValidation(userId);
	List<Product> allProductsList = productRepo.findAll();
	return allProductsList.stream().map(product -> mapper.map(product, ProductDto.class)).toList();
    }

}

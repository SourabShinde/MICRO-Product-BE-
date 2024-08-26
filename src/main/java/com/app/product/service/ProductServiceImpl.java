package com.app.product.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Object createProduct(ProductDto productDto) {
		log.info("In create Product method() from class {} :: {}", ProductServiceImpl.class, new Date());
		validateProduct(productDto);
		Product p = mapper.map(productDto, Product.class);
		Utilities.setAuditFields(1212, p, false);
		productRepo.save(p);
		log.info("Product {} saved successfully. at {}", p.getName(), new Date());

		List<Product> products = productRepo.findAll();
		return products;
	}

	private void validateProduct(ProductDto productDto) {
		log.info("In Validate Product method() from class " + ProductServiceImpl.class + " :: " + new Date());
		if (!Utilities.isNotBlank(productDto.getName())) {
			throw new ProductException("Product name is mandatory.",
					new ErrorResponse(ErrorResponse.NOT_FOUND, "Product name is mandatory."));
		}

		if (productRepo.existsByName(productDto.getName())) {
			throw new ProductException("Duplicate product.",
					new ErrorResponse(ErrorResponse.DUPLICATE, "Duplicate product."));
		}

	}

}

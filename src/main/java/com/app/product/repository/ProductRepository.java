package com.app.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	public boolean existsByName(String name);

}

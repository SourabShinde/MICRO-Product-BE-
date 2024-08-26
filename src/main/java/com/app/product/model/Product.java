package com.app.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(value = "product")
@Getter
@Setter
public class Product extends AuditableEntity<String> {

	@Id
	private String id;

	private String name;

	private String description;

	private double price;

}

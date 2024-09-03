package com.app.product.model;

import java.math.BigDecimal;
import java.util.List;

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

//    private Integer quantity;
//
//    private String category;// Can use ENUM Constants
//
//    private String brand;
//
//    private Double weight;
//
//    private String dimensions;
//
//    private String imageUrl;
//
//    private String status;// Can use ENUM Constants
//
//    private BigDecimal discount;
//
//    private List<String> tags;
//
//    private Double ratings;
//
//    private List<String> reviews;
//
//    private String supplier;
//
//    private String warrantyPeriod;

}

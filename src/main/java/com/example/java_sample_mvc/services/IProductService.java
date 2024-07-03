package com.example.java_sample_mvc.services;

import com.example.java_sample_mvc.models.Product;

import java.util.List;

public interface IProductService {
    Product findOne(int id);
    List<Product> findAll();

    List<Product> findByCategory(int id);

    Product create(Product product);
    Product update(int id, Product product);
    boolean delete(int id);
}

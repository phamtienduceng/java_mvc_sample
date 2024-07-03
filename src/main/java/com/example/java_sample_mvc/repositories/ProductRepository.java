package com.example.java_sample_mvc.repositories;

import com.example.java_sample_mvc.models.Category;
import com.example.java_sample_mvc.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByCategory(Category category);
}

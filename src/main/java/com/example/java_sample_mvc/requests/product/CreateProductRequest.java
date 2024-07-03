package com.example.java_sample_mvc.requests.product;

import com.example.java_sample_mvc.models.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private int categoryId;
}

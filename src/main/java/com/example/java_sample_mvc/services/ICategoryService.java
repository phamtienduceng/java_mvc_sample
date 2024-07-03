package com.example.java_sample_mvc.services;

import com.example.java_sample_mvc.models.Category;

import java.util.List;

public interface ICategoryService {
    Category findOne(int id) ;

    List<Category> findAll();

    Category create(Category category) throws Exception;

    Category update(int id, Category category);

    boolean delete(int id);
}

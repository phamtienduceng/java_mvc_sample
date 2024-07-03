package com.example.java_sample_mvc.services;

import com.example.java_sample_mvc.models.Category;
import com.example.java_sample_mvc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category findOne(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(Category category) {
        try{
            return categoryRepository.save(category);
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public Category update(int id, Category category) {
        Category cate = findOne(id);
        if(cate != null){
            try{
                cate.setName(category.getName());
                return categoryRepository.save(cate);
            }catch(Exception ex){
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Category cate = findOne(id);
        if(cate != null){
            try{
                categoryRepository.delete(cate);
                return true;
            }catch(Exception ex){
                return false;
            }
        }
        return false;
    }
}

package com.example.java_sample_mvc.services;

import com.example.java_sample_mvc.models.Category;
import com.example.java_sample_mvc.models.Product;
import com.example.java_sample_mvc.repositories.CategoryRepository;
import com.example.java_sample_mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product findOne(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategory(int id) {
        Category cate = categoryRepository.findById(id).get();
        return productRepository.findProductByCategory(cate);
    }

    @Override
    public Product create(Product product) {
        try{
            return productRepository.save(product);
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public Product update(int id, Product product) {
        Product pro = findOne(id);
        if(pro != null){
            try{
                pro.setName(pro.getName());
                return productRepository.save(pro);
            }catch(Exception ex){
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Product pro = findOne(id);
        if(pro != null){
            try{
                productRepository.delete(pro);
                return true;
            }catch(Exception ex){
                return false;
            }
        }
        return false;
    }
}

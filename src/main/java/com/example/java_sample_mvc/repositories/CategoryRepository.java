package com.example.java_sample_mvc.repositories;


import com.example.java_sample_mvc.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

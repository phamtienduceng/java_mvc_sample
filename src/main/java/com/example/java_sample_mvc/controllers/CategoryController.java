package com.example.java_sample_mvc.controllers;

import com.example.java_sample_mvc.models.Category;
import com.example.java_sample_mvc.requests.category.CreateCategoryRequest;
import com.example.java_sample_mvc.requests.category.UpdateCategoryRequest;
import com.example.java_sample_mvc.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/new")
    public String createCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "create_category";
    }

    @PostMapping
    public String saveCategory(@ModelAttribute("category") CreateCategoryRequest rq) {
        Category category = modelMapper.map(rq, Category.class);
        categoryService.create(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findOne(id));
        return "edit_category";
    }

    @PostMapping("/{id}")
    public String updateCategory(@PathVariable int id, @ModelAttribute("category") UpdateCategoryRequest rq) {
        Category category = modelMapper.map(rq, Category.class);
        categoryService.update(id, category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}

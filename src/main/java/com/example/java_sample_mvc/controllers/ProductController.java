// src/main/java/com/example/productcategoryapp/controller/ProductController.java
package com.example.java_sample_mvc.controllers;

import com.example.java_sample_mvc.models.Category;
import com.example.java_sample_mvc.models.Product;
import com.example.java_sample_mvc.requests.product.CreateProductRequest;
import com.example.java_sample_mvc.requests.product.UpdateProductRequest;
import com.example.java_sample_mvc.services.CategoryService;
import com.example.java_sample_mvc.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/new")
    public String createProductForm(Model model) {
        model.addAttribute("product", new CreateProductRequest());
        model.addAttribute("categories", categoryService.findAll());
        return "create_product";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute("product") CreateProductRequest rq) {
        Product product = new Product();
        product.setName(rq.getName());
        product.setDescription(rq.getDescription());
        product.setPrice(rq.getPrice());
        product.setStock(rq.getStock());
        Category category = categoryService.findOne(rq.getCategoryId());
        product.setCategory(category);
        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findOne(id));
        model.addAttribute("categories", categoryService.findAll());
        return "edit_product";
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute("product") UpdateProductRequest rq) {
        Product pro = modelMapper.map(rq, Product.class);
        productService.update(id, pro);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}

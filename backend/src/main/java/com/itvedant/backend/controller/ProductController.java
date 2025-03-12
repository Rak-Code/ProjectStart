package com.itvedant.backend.controller;

import com.itvedant.backend.model.Product;
import com.itvedant.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get products by category
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable int categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    // Add a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Get a single product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

}

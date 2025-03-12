package com.itvedant.backend.service;

import com.itvedant.backend.model.Product;
import com.itvedant.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Fetch all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Fetch products by category
    public List<Product> getProductsByCategory(int categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    // Add a new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

}

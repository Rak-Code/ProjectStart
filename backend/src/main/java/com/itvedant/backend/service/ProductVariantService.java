package com.itvedant.backend.service;

import com.itvedant.backend.model.ProductVariant;
import com.itvedant.backend.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductVariantService {

    @Autowired
    private ProductVariantRepository productVariantRepository;

    // Fetch all product variants
    public List<ProductVariant> getAllProductVariants() {
        return productVariantRepository.findAll();
    }

    // Fetch variants by product ID
    public List<ProductVariant> getVariantsByProductId(int productId) {
        return productVariantRepository.findByProductId(productId);
    }

    // Add a new product variant
    public ProductVariant addProductVariant(ProductVariant productVariant) {
        return productVariantRepository.save(productVariant);
    }
}

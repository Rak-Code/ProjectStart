package com.itvedant.backend.controller;

import com.itvedant.backend.model.ProductVariant;
import com.itvedant.backend.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-variants")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductVariantController {

    @Autowired
    private ProductVariantService productVariantService;

    // Get all product variants
    @GetMapping
    public List<ProductVariant> getAllProductVariants() {
        return productVariantService.getAllProductVariants();
    }

    // Get variants by product ID
    @GetMapping("/product/{productId}")
    public List<ProductVariant> getVariantsByProductId(@PathVariable int productId) {
        return productVariantService.getVariantsByProductId(productId);
    }

    // Add a new product variant
    @PostMapping
    public ProductVariant addProductVariant(@RequestBody ProductVariant productVariant) {
        return productVariantService.addProductVariant(productVariant);
    }
}

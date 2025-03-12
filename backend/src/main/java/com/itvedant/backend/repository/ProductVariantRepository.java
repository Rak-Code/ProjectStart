package com.itvedant.backend.repository;

import com.itvedant.backend.model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Integer> {
    List<ProductVariant> findByProductId(int productId);
}

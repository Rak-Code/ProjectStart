package com.itvedant.backend.repository;

import com.itvedant.backend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUserId(int userId);
    List<CartItem> findByUserIdAndProductVariantId(int userId, int productVariantId);
}
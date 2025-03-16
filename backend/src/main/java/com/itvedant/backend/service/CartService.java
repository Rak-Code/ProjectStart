package com.itvedant.backend.service;

import com.itvedant.backend.model.CartItem;
import com.itvedant.backend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemsByUserId(int userId) {
        return cartItemRepository.findByUserId(userId);
    }

    public CartItem addToCart(CartItem cartItem) {
        // Check if item already exists in cart
        List<CartItem> existingItems = cartItemRepository.findByUserIdAndProductVariantId(
                cartItem.getUser().getId(), 
                cartItem.getProductVariant().getId());
        
        if (!existingItems.isEmpty()) {
            // Update quantity if item already exists
            CartItem existingItem = existingItems.get(0);
            existingItem.setQuantity(existingItem.getQuantity() + cartItem.getQuantity());
            return cartItemRepository.save(existingItem);
        }
        
        // Add new item to cart
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(int itemId, CartItem cartItem) {
        CartItem existingItem = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        
        existingItem.setQuantity(cartItem.getQuantity());
        return cartItemRepository.save(existingItem);
    }

    public void removeFromCart(int itemId) {
        cartItemRepository.deleteById(itemId);
    }
}
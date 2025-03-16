package com.itvedant.backend.controller;

import com.itvedant.backend.model.CartItem;
import com.itvedant.backend.model.User;
import com.itvedant.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable int userId) {
        List<CartItem> cartItems = cartService.getCartItemsByUserId(userId);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/add")
    public ResponseEntity<CartItem> addToCart(@RequestBody CartItem cartItem) {
        CartItem savedItem = cartService.addToCart(cartItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable int itemId, @RequestBody CartItem cartItem) {
        CartItem updatedItem = cartService.updateCartItem(itemId, cartItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable int itemId) {
        cartService.removeFromCart(itemId);
        return ResponseEntity.noContent().build();
    }
}
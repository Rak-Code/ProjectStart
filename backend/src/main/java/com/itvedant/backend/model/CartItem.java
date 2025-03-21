package com.itvedant.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;

    private int quantity;

	public User getUser() {
		// TODO Auto-generated method stub
		return user;
	}

	public ProductVariant getProductVariant() {
		// TODO Auto-generated method stub
		return productVariant;
	}

	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	public void setQuantity(int quantity) {
		// TODO Auto-generated method stub
		this.quantity = quantity;
		
	}
}

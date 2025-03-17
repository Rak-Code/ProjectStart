package com.itvedant.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;

    private int quantity;
    private double price;
    
    // Manual Builder implementation
    public static OrderItemBuilder builder() {
        return new OrderItemBuilder();
    }
    
    public static class OrderItemBuilder {
        private int id;
        private Order order;
        private ProductVariant productVariant;
        private int quantity;
        private double price;
        
        OrderItemBuilder() {
        }
        
        public OrderItemBuilder id(int id) {
            this.id = id;
            return this;
        }
        
        public OrderItemBuilder order(Order order) {
            this.order = order;
            return this;
        }
        
        public OrderItemBuilder productVariant(ProductVariant productVariant) {
            this.productVariant = productVariant;
            return this;
        }
        
        public OrderItemBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        
        public OrderItemBuilder price(double price) {
            this.price = price;
            return this;
        }
        
        public OrderItem build() {
            return new OrderItem(id, order, productVariant, quantity, price);
        }
    }
}

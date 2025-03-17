package com.itvedant.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime orderDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    
    private String customerName;
    private String email;
    private String phone;
    
    @Column(columnDefinition = "TEXT")
    private String shippingAddress;
    
    @Column(columnDefinition = "TEXT")
    private String billingAddress;
    
    private String paymentMethod;
    
    private double totalAmount;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public enum Status {
        PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED
    }

    // Manual setter for status
    public void setStatus(Status status) {
        this.status = status;
    }
    
    // Manual Builder implementation
    public static OrderBuilder builder() {
        return new OrderBuilder();
    }
    
    public static class OrderBuilder {
        private int id;
        private User user;
        private LocalDateTime orderDate = LocalDateTime.now();
        private Status status = Status.PENDING;
        private String customerName;
        private String email;
        private String phone;
        private String shippingAddress;
        private String billingAddress;
        private String paymentMethod;
        private double totalAmount;
        private List<OrderItem> items;
        
        OrderBuilder() {
        }
        
        public OrderBuilder id(int id) {
            this.id = id;
            return this;
        }
        
        public OrderBuilder user(User user) {
            this.user = user;
            return this;
        }
        
        public OrderBuilder orderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        
        public OrderBuilder status(Status status) {
            this.status = status;
            return this;
        }
        
        public OrderBuilder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }
        
        public OrderBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        public OrderBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        
        public OrderBuilder shippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }
        
        public OrderBuilder billingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }
        
        public OrderBuilder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }
        
        public OrderBuilder totalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }
        
        public OrderBuilder items(List<OrderItem> items) {
            this.items = items;
            return this;
        }
        
        public Order build() {
            Order order = new Order();
            order.id = this.id;
            order.user = this.user;
            order.orderDate = this.orderDate;
            order.status = this.status;
            order.customerName = this.customerName;
            order.email = this.email;
            order.phone = this.phone;
            order.shippingAddress = this.shippingAddress;
            order.billingAddress = this.billingAddress;
            order.paymentMethod = this.paymentMethod;
            order.totalAmount = this.totalAmount;
            order.items = this.items;
            return order;
        }
    }
}
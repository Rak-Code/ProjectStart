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

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
}
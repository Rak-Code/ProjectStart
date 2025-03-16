package com.itvedant.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itvedant.backend.model.CartItem;
import com.itvedant.backend.model.Order;
import com.itvedant.backend.model.OrderItem;
import com.itvedant.backend.model.User;
import com.itvedant.backend.repository.CartItemRepository;
import com.itvedant.backend.repository.OrderItemRepository;
import com.itvedant.backend.repository.OrderRepository;
import com.itvedant.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, 
                        OrderItemRepository orderItemRepository,
                        CartItemRepository cartItemRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Transactional
    public Order createOrder(Map<String, Object> orderData) {
        // Hardcoded user for now - in a real app, this would come from authentication
        User user = userRepository.findById(1).orElseThrow(() -> new RuntimeException("User not found"));
        
        // Extract data from the request
        String customerName = (String) orderData.get("customerName");
        String email = (String) orderData.get("email");
        String phone = (String) orderData.get("phone");
        String paymentMethod = (String) orderData.get("paymentMethod");
        
        // Convert address objects to JSON strings
        String shippingAddress;
        String billingAddress;
        try {
            shippingAddress = objectMapper.writeValueAsString(orderData.get("shippingAddress"));
            billingAddress = objectMapper.writeValueAsString(orderData.get("billingAddress"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize address", e);
        }
        
        // Get user's cart items
        List<CartItem> cartItems = cartItemRepository.findByUserId(user.getId());
        
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }
        
        // Calculate total amount
        double totalAmount = cartItems.stream()
                .mapToDouble(item -> item.getProductVariant().getPrice() * item.getQuantity())
                .sum();
        
        // Add taxes and shipping if applicable
        double tax = totalAmount * 0.18; // 18% GST
        double shipping = totalAmount > 500 ? 0 : 50;
        totalAmount = totalAmount + tax + shipping;
        
        // Create new order
        Order order = Order.builder()
                .user(user)
                .customerName(customerName)
                .email(email)
                .phone(phone)
                .shippingAddress(shippingAddress)
                .billingAddress(billingAddress)
                .paymentMethod(paymentMethod)
                .totalAmount(totalAmount)
                .status(Order.Status.PENDING)
                .build();
        
        order = orderRepository.save(order);
        
        // Create order items from cart items
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .productVariant(cartItem.getProductVariant())
                    .quantity(cartItem.getQuantity())
                    .price(cartItem.getProductVariant().getPrice())
                    .build();
            
            orderItemRepository.save(orderItem);
            orderItems.add(orderItem);
        }
        
        // Clear the user's cart
        cartItemRepository.deleteAll(cartItems);
        
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(int id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order updateOrderStatus(int orderId, Order.Status status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public List<OrderItem> getOrderItems(int orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
}
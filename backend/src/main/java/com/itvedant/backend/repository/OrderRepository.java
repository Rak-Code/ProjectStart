package com.itvedant.backend.repository;

import com.itvedant.backend.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	 List<Order> findByUserId(int userId);
}

package com.liferay.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liferay.course.entities.Order;
import com.liferay.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> objOptional = orderRepository.findById(id);
		return objOptional.get();
	}
	
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}
	
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

}

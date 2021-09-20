package com.liferay.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liferay.course.entities.Order;
import com.liferay.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> orders = orderService.findAll();
		return ResponseEntity.ok().body(orders);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order objOrder = orderService.findById(id);
		return ResponseEntity.ok().body(objOrder);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		orderService.deleteById(id);
	}

}

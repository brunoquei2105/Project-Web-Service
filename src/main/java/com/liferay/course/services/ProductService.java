package com.liferay.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liferay.course.entities.Product;
import com.liferay.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
		
	}
	public Product findById(Long id) {
		Optional<Product> objOptional = productRepository.findById(id);
		return objOptional.get();
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

}

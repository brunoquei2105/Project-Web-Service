package com.liferay.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liferay.course.entities.Product;
import com.liferay.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		List<Product> products = productService.findAll();
		
		return ResponseEntity.ok().body(products);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id){
		
		Product product = productService.findById(id);
		return ResponseEntity.ok().body(product);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		productService.deleteById(id);
	}

}

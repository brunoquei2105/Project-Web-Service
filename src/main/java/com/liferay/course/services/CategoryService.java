package com.liferay.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liferay.course.entities.Category;
import com.liferay.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> objOptional = categoryRepository.findById(id);
		return objOptional.get();
	}
	
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}
	
	



}
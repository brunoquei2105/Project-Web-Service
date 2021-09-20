package com.liferay.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liferay.course.entities.User;
import com.liferay.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	public User findById(Long id) {
		Optional<User> objOptional = userRepository.findById(id);
		return objOptional.get();
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}

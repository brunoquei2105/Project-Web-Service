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
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public User updaUser(Long id, User user) {
		User entityUser = userRepository.getOne(id);
		updateData(entityUser, user);
		return userRepository.save(entityUser);
}
	private void updateData(User entityUser, User user) {
		
		entityUser.setName(user.getName());
		entityUser.setEmail(user.getEmail());
		entityUser.setPhone(user.getPhone());
	}
	
}

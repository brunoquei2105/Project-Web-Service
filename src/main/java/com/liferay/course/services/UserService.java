package com.liferay.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.liferay.course.entities.User;
import com.liferay.course.repositories.UserRepository;
import com.liferay.course.services.exceptions.DatabaseException;
import com.liferay.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	public User findById(Long id) {
		Optional<User> objOptional = userRepository.findById(id);
		return objOptional.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		try {
			userRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
			
		}
	}
	
	@SuppressWarnings("deprecation")
	public User updaUser(Long id, User user) {
		try {
		User entityUser = userRepository.getOne(id);
		updateData(entityUser, user);
		
		return userRepository.save(entityUser);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
}
	private void updateData(User entityUser, User user) {
		
		entityUser.setName(user.getName());
		entityUser.setEmail(user.getEmail());
		entityUser.setPhone(user.getPhone());
	}
	
}

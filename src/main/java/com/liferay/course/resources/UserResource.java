package com.liferay.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liferay.course.entities.User;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "bruno", "bruno@gmail.com", "81991819547", "123eja");
		return ResponseEntity.ok().body(user);
		
	}
}

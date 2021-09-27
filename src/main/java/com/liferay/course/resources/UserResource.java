package com.liferay.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.liferay.course.entities.User;
import com.liferay.course.services.UserService;


@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> userList = service.findAll();
		
		return ResponseEntity.ok().body(userList);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User objUser = service.findById(id);
		return ResponseEntity.ok().body(objUser);
	}
	
	@PostMapping
	public ResponseEntity<User> postUser(@RequestBody User user){
		user = service.createUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable Long id, 
			@RequestBody User user){
		user = service.updaUser(id, user);
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
		
	}
}

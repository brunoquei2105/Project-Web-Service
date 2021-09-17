package com.liferay.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.liferay.course.entities.User;
import com.liferay.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(1L, "Mary Brown", "mary@gmail.com","8171147576", "123456");
		User u2 = new User(2L, "Bob Taylo", "bob@gmail.com","8171146444", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	

}

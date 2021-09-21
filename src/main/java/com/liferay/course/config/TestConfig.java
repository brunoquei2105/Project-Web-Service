package com.liferay.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.time.Instant;

import com.liferay.course.entities.Category;
import com.liferay.course.entities.Order;
import com.liferay.course.entities.User;
import com.liferay.course.entities.enums.OrderStatus;
import com.liferay.course.repositories.CategoryRepository;
import com.liferay.course.repositories.OrderRepository;
import com.liferay.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(1L, "Mary Brown", "mary@gmail.com","8171147576", "123456");
		User u2 = new User(2L, "Bob Taylo", "bob@gmail.com","8171146444", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null,"Books" );
		Category c3 = new Category(null,"Computers" );
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
	}
	

}

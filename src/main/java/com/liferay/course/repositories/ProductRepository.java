package com.liferay.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liferay.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

package com.liferay.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liferay.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

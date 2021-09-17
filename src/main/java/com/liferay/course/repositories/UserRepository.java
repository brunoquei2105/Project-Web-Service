package com.liferay.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liferay.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

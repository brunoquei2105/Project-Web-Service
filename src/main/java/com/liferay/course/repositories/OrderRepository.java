package com.liferay.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liferay.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

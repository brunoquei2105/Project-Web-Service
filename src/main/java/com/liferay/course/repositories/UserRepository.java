package com.liferay.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liferay.course.entities.User;

//Não seria necessario colocar essa anotação @Repository pois a classe
//UserRepository extends JpaRepository que já esta resgristrada com essa anotação.
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

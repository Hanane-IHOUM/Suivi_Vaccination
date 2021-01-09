package com.proj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proj.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.email like :x")
	public User chercher(@Param("x")String email);

}


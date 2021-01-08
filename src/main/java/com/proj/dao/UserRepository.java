package com.proj.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proj.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}


package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Users;



public interface UserRepository  extends JpaRepository<Users, Long>{

	Users findByUsername(String username);

}

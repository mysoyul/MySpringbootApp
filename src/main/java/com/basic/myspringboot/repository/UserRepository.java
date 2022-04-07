package com.basic.myspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.myspringboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}

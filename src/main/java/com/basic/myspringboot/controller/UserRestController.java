package com.basic.myspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}

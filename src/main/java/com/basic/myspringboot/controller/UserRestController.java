package com.basic.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
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
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> optional = userRepository.findById(id);
		User existUser = optional.orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
		return existUser;
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();
	}
}

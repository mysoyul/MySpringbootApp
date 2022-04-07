package com.basic.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		return userService.updateUser(id,userDetail);
	}
	//ResponseEntity
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		return userService.deleteUser(id);
	}
}

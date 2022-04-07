package com.basic.myspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.basic.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository userRepository;
	
	
}

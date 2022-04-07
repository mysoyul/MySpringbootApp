package com.basic.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.basic.myspringboot.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserRepository userRepository;

//	public UserController(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	@GetMapping("/thymeleaf")
	public String leaf(Model model) {
		model.addAttribute("name", "스프링부트");
		return "leaf";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

}

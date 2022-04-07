package com.basic.myspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User updateUser(Long id, User userDetail) {
		User existUser = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
		//setter method 호출
		existUser.setName(userDetail.getName());
		existUser.setEmail(userDetail.getEmail());
		return existUser;
		//User updateUser = userRepository.save(existUser);
		//return updateUser;
	}
}

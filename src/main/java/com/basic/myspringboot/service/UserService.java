package com.basic.myspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	@Transactional
	public User updateUser(Long id, User userDetail) {
		User existUser = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
		//setter method 호출해도 update 처리가 된다.
		existUser.setName(userDetail.getName());
		existUser.setEmail(userDetail.getEmail());
		return existUser;
		//User updateUser = userRepository.save(existUser);
		//return updateUser;
	}
	
	public User getUser(Long id) {
		Optional<User> optional = userRepository.findById(id);
		User existUser = optional.orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
		return existUser;
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@Transactional
	public ResponseEntity<?> deleteUser(Long id){
		Optional<User> optional = userRepository.findById(id);
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "User Not Found");
		}
		User user = optional.get();
		userRepository.delete(user);
		return ResponseEntity.ok().build();
	}
}

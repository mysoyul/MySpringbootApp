package com.basic.myspringboot.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.basic.myspringboot.entity.Account;
import com.basic.myspringboot.property.MybootProperties;
import com.basic.myspringboot.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService{
	private final AccountRepository accountRepository;
	private final MybootProperties property;

	// Account 레코드 추가
	public Account createAccount(String username, String password) {
		Account account = Account.builder().username(username).password(password).build();
		return accountRepository.save(account);
	}

	@PostConstruct
	public void init() {
		Optional<Account> byUsername = accountRepository.findByUsername(property.getUsername());
		if (!byUsername.isPresent()) {
			Account newAccount = this.createAccount(property.getUsername(), property.getPassword());
			System.out.println(newAccount);
		}
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}

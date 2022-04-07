package com.basic.myspringboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
public class AccountService implements UserDetailsService {
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
		Optional<Account> byUsername = accountRepository.findByUsername(username);
		Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));
		return new User(account.getUsername(), account.getPassword(), authorities());

	}

	// User 객체의 세번째 인자 USER라는 ROLE을 가진 사용자이다 라고 설정하는 부분
	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

}

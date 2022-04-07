package com.basic.myspringboot.service;

import org.springframework.stereotype.Service;

import com.basic.myspringboot.entity.Account;
import com.basic.myspringboot.property.MybootProperties;
import com.basic.myspringboot.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository accountRepository;
	private final MybootProperties property;

	// Account 레코드 추가
	public Account createAccount(String username, String password) {
		Account account = Account.builder()
							.username(username)
							.password(password)
							.build();
		return accountRepository.save(account);
	}
}

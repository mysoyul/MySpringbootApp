package com.basic.myspringboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.basic.myspringboot.entity.Account;
//run : ctrl + f11
@SpringBootTest
public class AccountRepositoryTest {

	@Autowired
	AccountRepository repository;
	
	@Test
	public void insert_select() throws Exception {
		Account account = Account.builder()
								.username("boot")
								.password("1234")
								.build();
		
		Account savedAccount = repository.save(account);
		System.out.println(savedAccount.getId() + " " + savedAccount.getUsername());
		assertEquals(1L, savedAccount.getId());
		assertEquals("boot", savedAccount.getUsername());
		
		Optional<Account> optional = repository.findById(2L);
		System.out.println(optional.isPresent());
		if(optional.isPresent()) {
			Account existAccount = optional.get();
			assertEquals("boot", existAccount.getUsername());
		}
		
		Account acct = Account.builder()
				.username("test")
				.password("1234")
				.build();
		
		Account account2 = optional.orElse(acct);
		
		System.out.println("Account2 : " + account2.getUsername());
		System.out.println("Account : " + acct.getUsername());
	}
}

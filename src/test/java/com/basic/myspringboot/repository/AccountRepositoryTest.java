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
		if(optional.isPresent()) { //true
			Account existAccount = optional.get(); //optional에서 account 꺼내기
			assertEquals("boot", existAccount.getUsername());
		}
		
		Account acct = Account.builder()
				.username("test")
				.password("1234")
				.build();
		
		Account account2 = optional.orElse(acct);
		
		System.out.println("Account2 : " + account2.getUsername());
		System.out.println("Account : " + acct.getUsername());
		//orElseGet() 의 아규먼트 Supplier 추상메서드 T get()
		Account account3 = optional.orElseGet(() -> new Account(0L, "", ""));
		System.out.println(account3.getId());
		//orElseGet() 의 아규먼트 Supplier <X extends Throwable>
		account3 = optional.orElseThrow(() -> new RuntimeException("Account Not Found"));
	}
}

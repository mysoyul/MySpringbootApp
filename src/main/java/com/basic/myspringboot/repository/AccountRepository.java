package com.basic.myspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.myspringboot.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}

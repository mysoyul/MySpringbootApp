package com.basic.myspringboot.runner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class DBRunner implements ApplicationRunner{
	@Autowired
	DataSource dataSource;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.debug("DataSource 구현체 = {}  ", dataSource.getClass().getName());
		
		Connection connection = dataSource.getConnection();
		DatabaseMetaData metaData = connection.getMetaData();
		log.debug("DB Vendor Name = {}", metaData.getDatabaseProductName());
		log.debug("DB URL = {} ", metaData.getURL());
		log.debug("DB Username = {} ", metaData.getUserName());
	}
}
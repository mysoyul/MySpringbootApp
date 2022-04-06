package com.basic.myspringboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.basic.myspringboot.property.MybootProperties;

@Component
public class MyRunner implements ApplicationRunner {
	private Logger logger = LoggerFactory.getLogger(MyRunner.class);
			
	@Value("${myboot.name}")
	String name;
	
	@Autowired
	Environment env;
	
	@Autowired
	MybootProperties property;
	
	@Autowired
	String hello;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Logger 구현 클래스 이름 " + logger.getClass().getName());
		logger.debug("현재 적용된 Mode = " + hello);
		logger.debug("환경변수 Name = " + name);
		logger.debug("환경변수 Age = " + env.getProperty("myboot.age"));
		logger.debug("Property 클래스 fullName " + property.getFullName());
		
		logger.info("Program Argument = " + args.containsOption("bar"));
		logger.info("VM Argument = " + args.containsOption("foo"));
		
	}
}

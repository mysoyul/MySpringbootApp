package com.basic.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyspringbootAppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MyspringbootAppApplication.class, args);
		SpringApplication application = new SpringApplication(MyspringbootAppApplication.class);
		//Application 타입 설정
		//Web project 아닌 일반 Java Project 로 설정
		//application.setWebApplicationType(WebApplicationType.NONE);
		
		//Web Project로 설정하기
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
	}

}

package com.basic.myspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/mypage/**","/userindex/**").authenticated()
			.antMatchers("/**").permitAll()
			.and()
			.formLogin()
			.and()
			.httpBasic()
			.and()
			.logout() // logout configuration
			.logoutUrl("/app-logout")
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/");
	}
}

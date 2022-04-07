package com.basic.myspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Entity
@Data
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	//@JsonIgnore
	@JacksonXmlProperty
	@NotEmpty(message = "Name 반드시 입력해에 공백문자는 가능함")
	private String name;
	
	@NotBlank(message = "Email은 꼭 입력해에 공백문자도 않됨")
	@JacksonXmlProperty
	@Column(unique = true)
	private String email;
	
}

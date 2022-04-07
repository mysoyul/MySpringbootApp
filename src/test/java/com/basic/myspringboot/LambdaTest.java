package com.basic.myspringboot;

import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LambdaTest {

	@Test
	public void iterable() {
		List<String> strList = List.of("java","javascript","python");
		//1. annonymous inner class
		strList.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);				
			}
		});
		//2. Lambda expression
		strList.forEach(val -> System.out.println("==="+ val));
		//3. Method Reference
		strList.forEach(System.out::println);
		
	}
	
	@Test @Disabled
	public void runnable() {
		//1. annonymous inner class
		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("Annonymous Inner Class");				
			}
		});		
		t1.start();
		//2. Lambda expression
		Thread t2 = new Thread(() -> System.out.println("Lambda Expression"));
		t2.start();		
	}
	
	
}

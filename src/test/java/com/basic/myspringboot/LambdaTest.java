package com.basic.myspringboot;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LambdaTest {

	@Test
	public void iterable() {
		
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

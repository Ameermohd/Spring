package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("SopeDemo-applicationContext.xml");
	
	 Coach thecoach = context.getBean("myCoach",Coach.class);
	 
	 Coach alphacoach = context.getBean("myCoach",Coach.class);
	 
	 boolean flag =(thecoach==alphacoach);
	 
	 System.out.println("Same? "+flag);
	 
	 System.out.println("thecoach :"+thecoach);

	 System.out.println("alphacoach :"+alphacoach);

	}

}

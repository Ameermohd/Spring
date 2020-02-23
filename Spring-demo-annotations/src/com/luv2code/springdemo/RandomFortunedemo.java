package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomFortunedemo {
 
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		RandomFortuneService thecoach = context.getBean("randomFortuneService",RandomFortuneService.class);
		
		System.out.println(thecoach.getFortune());
		
	}

}

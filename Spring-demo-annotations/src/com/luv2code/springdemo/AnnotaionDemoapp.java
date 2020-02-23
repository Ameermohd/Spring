package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotaionDemoapp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Tenniscoach thecoach = context.getBean("tenniscoach",Tenniscoach.class);
		
		System.out.println(thecoach.getDalyworkout());
		
		System.out.println(thecoach.getFortune());
		
		System.out.println(thecoach.getEmail());
		
		System.out.println(thecoach.getMobile());
		
		context.close();
	}

}

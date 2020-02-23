package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class setterDemoapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrieve bean from spring container
		Cricketcoach theCoach = context.getBean("myCricketcoach", Cricketcoach.class);
	
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getTodayFortune());
		
		System.out.println(theCoach.getEmail());
		
		context.close();

	}

}

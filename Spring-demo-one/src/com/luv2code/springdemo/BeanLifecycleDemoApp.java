package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("BeanLifecycleDemo-applicationContext.xml");
	
	 Coach thecoach = context.getBean("myCoach",Coach.class);
	 
	 Coach thecoacher = context.getBean("myCoacher",Coach.class);

	 System.out.println(thecoach.getDailyWorkout());
	 
	 System.out.println(thecoacher.getDailyWorkout());
	 
	 context.close();

	}

}

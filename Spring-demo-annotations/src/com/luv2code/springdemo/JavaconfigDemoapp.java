package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaconfigDemoapp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Sportconfig.class);
		
		Swimcoach thecoach = context.getBean("swimcoach",Swimcoach.class);
		
		System.out.println(thecoach.getDalyworkout());
		
		System.out.println(thecoach.getFortune());
		
		System.out.println(thecoach.getEmail());
		
		System.out.println(thecoach.getMobile());
		
		
		context.close();
	}

}

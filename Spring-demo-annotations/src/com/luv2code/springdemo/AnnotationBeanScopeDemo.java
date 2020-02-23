package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext thecontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach thecoach = thecontext.getBean("tenniscoach",Coach.class);
		
		Coach alphacoach = thecontext.getBean("tenniscoach",Coach.class);
		
		boolean check =(thecoach==alphacoach);
		
		System.out.println("Objects are Equal?"+check);

		
		thecontext.close();
	
	}

}

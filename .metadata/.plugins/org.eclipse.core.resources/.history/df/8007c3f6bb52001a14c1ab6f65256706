package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class Aroundemoapp {
	
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		String data = theTrafficFortuneService.getFortune();
		System.out.println("My fortune is, " + data);
		
		System.out.println("Finished!");
		
		context.close();
		
	}

}

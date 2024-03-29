package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class Aroundhandleexceptiondemoapp {
	
	public static Logger mylogger = Logger.getLogger(Aroundhandleexceptiondemoapp.class.getName());
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		boolean tripwire = true;
		String data = theTrafficFortuneService.getFortune(tripwire);
		mylogger.info("My fortune is, " + data);
		
		mylogger.info("Finished!");
		
		context.close();
		
	}

}

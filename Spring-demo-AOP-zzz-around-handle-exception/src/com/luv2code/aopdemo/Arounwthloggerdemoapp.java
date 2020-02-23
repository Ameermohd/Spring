package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class Arounwthloggerdemoapp {
	
	public static Logger mylogger = Logger.getLogger(Arounwthloggerdemoapp.class.getName());
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		String data = theTrafficFortuneService.getFortune(false);
		mylogger.info("My fortune is, " + data);
		
		mylogger.info("Finished!");
		
		context.close();
		
	}

}

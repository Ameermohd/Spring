package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Tenniscoach implements Coach{
	@Autowired
	@Qualifier("randomFortuneService")
	Fortuneservice fortune; //Field Injection
	
	@Value("${Email}")
	private String email;
	
	@Value("${Mobile}")
	private String mobile;
	
	
//	@Autowired
//	public Tenniscoach(Fortuneservice fortuneservice) {
//		
//		this.fortune =fortuneservice; //Constructor Injection
//		
//	}
	
	
	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	@Override
	@PostConstruct
	public String getDalyworkout() {
		 return "Practice daily 5 hr";
	}
	
	@PostConstruct
	public void doMystartupstuff()
	{
		System.out.println("TennisCoach: doMystartupstuff");
	}
	
	@PreDestroy
	public void doMycleanupstuff()
	{
		System.out.println("TennisCoach: doMycleanupstuff");
	}
	
//	@PreDestroy
//	public void doMycleanupstuff1()
//	{
//		System.out.println("TennisCoach: doMycleanupstuff1");
//	}
	
//	@Autowired
//	public void setFortune(Fortuneservice fortune) {
//		this.fortune = fortune; //Setter Injection
//	}

	public String getFortune() {
		return fortune.getFortune();
	}

}

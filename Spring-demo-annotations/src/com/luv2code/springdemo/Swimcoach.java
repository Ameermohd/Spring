package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;


public class Swimcoach implements Coach {
//	@Autowired
//	@Qualifier("sadfortuneservice")
	public Fortuneservice fortune;
	
	@Value("${Email}")
	public String email;
	
	@Value("${Mobile}")
	public String mobile;
	
	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	
	
	
//	Swimcoach()
//	{}
	
	
	//@Autowired
//	public Swimcoach(@Qualifier("sadfortuneservice") Fortuneservice fortuneservice) {
//		fortune=fortuneservice;
//		
//	}
	
	public Swimcoach(Fortuneservice fortuneservice)
	{
		fortune = fortuneservice;
	}
	
	@Override
	public String getDalyworkout() {
		return "Practice like never before";
	}

	@Override
	public String getFortune() {
		return fortune.getFortune();
		
	}
//	@PostConstruct
//	public void doMystartupstuff()
//	{
//		System.out.println("Swimcoach: doMystartupstuff");
//	}
	
//	@PreDestroy
//	public void doMycleanupstuff()
//	{
//		System.out.println("Swimcoach: doMycleanupstuff");
//	}
	
}

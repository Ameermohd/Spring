package com.luv2code.springdemo;

public class Cricketcoach implements Coach {
    Fortune fortuneservice;
    
    private String email;
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Cricketcoach()
    {
    	System.out.println("Cricketcoach: Constructor");
    }
    
	public void setFortuneservice(Fortune fortuneservice) {
		System.out.println("Cricketcoach: Setter");
		this.fortuneservice = fortuneservice;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Play Hard";
	}

	@Override
	public String getTodayFortune() {
		// TODO Auto-generated method stub
		return fortuneservice.getTodayFortune();
	}

}

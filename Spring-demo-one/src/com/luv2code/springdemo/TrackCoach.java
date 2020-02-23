package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	
	Todayfortune obj;
	
	TrackCoach()
	{}
	
	TrackCoach(Todayfortune obj)
	{
		this.obj=obj;
	}
	
	

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}



	@Override
	public String getTodayFortune() {
		// TODO Auto-generated method stub
		return obj.getTodayFortune();
	}

	public void doMystartupstuff()
	{
		System.out.println("TrakCoack: doMystartupstuff");
	}
	
	public void doMycleanupstuff()
	{
		System.out.println("TrakCoack: doMycleanupstuff");
	}
	
}











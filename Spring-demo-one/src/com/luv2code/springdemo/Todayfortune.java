package com.luv2code.springdemo;

import java.lang.reflect.Array;
import java.util.Random;

public class Todayfortune implements Fortune{

    private String fortunes[] = {"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"} ;
    
    Random rand =new Random();
    
	@Override
	public String getTodayFortune() {
		
		// TODO Auto-generated method stub
		int i=rand.nextInt(fortunes.length);
		return fortunes[i];
	}

}

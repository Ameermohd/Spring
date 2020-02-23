package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements Fortuneservice {
 
	@Value("${one}")
	String one;
	@Value("${two}")
	String two;
	@Value("${three}")
	String three;
	
	//String[] data = {one, two, three}; Was not initialized during bean Lifecycle
	
	String[] data;
	
	private Random myrand = new Random();
	@PostConstruct
	public void init()
	{
		System.out.println("Inside Post construct");
		data = new String[]{one, two, three};
	}
	
	
	@Override
	public String getFortune() {
		//String[] data = {one, two, three};

		int i = myrand.nextInt(data.length);
		return data[i];
	}

}

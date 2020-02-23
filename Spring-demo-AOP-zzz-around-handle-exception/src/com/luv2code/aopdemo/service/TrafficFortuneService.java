package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune(boolean tripwire) {
		
		if(tripwire) {
			throw new RuntimeException();
		}
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return fortune
		
		return "Expect Heavy Traffic this morning";	
	}
}

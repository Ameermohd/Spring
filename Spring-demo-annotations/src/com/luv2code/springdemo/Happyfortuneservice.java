package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Happyfortuneservice implements Fortuneservice {

	@Override
	public String getFortune() {
		return "Today is Good!";
	}

}

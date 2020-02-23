package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class Sportconfig {
	@Bean
	public Fortuneservice sadfortuneservice()
	{
		return new Sadfortuneservice();
	}
	@Bean
	public Coach swimcoach()
	{
		return new Swimcoach(sadfortuneservice());
	}


}

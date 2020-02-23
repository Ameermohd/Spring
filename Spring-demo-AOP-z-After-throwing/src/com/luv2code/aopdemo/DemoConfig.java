package com.luv2code.aopdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.luv2code.aopdemo.*")
public class DemoConfig {
	
	@Bean
	public AccountDAO accountdao() {
		return new AccountDAO();
	}
	
	@Bean
	public MembershipDAO membershipdao() {
		return new MembershipDAO();
	}

}

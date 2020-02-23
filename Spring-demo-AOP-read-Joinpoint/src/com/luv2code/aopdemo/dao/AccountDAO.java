package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public String name;
	
	public void addAccount(Account theaccount)
	{
		
		System.out.println(getClass()+" Inside addAccount");
	}
	
	public String dosomestuff()
	{
		System.out.println(getClass()+" Inside dosomestuff");
		return null;
	}

	public String getName() {
		System.out.println(getClass()+" Inside getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" Inside setName");
		this.name = name;
	}
	
	

}

package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public String name;
	
	public void addAccount(Account theaccount)
	{
		theaccount.setName("John");
		System.out.println(getClass()+" Inside addAccount");
		System.out.println(theaccount.getName());
	}
	
	public String dosomestuff()
	{
		System.out.println(getClass()+" Inside dosomestuff");
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

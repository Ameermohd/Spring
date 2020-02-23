package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public String name;
	
	public List<Account> theaccounts = new ArrayList<Account>();
	
	public void addAccount(Account theaccount)
	{
		theaccounts.add(theaccount);
		
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
	
	public ArrayList<Account> findAccounts()
	{
		
		
		return (ArrayList<Account>) theaccounts;
		
	}
	
	

}

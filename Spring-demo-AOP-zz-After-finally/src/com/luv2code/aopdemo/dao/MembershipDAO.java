package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	
	public void addAccount()
	{
		System.out.println(getClass()+" Inside addAccount");
	}
	
	public boolean dowork() {
		System.out.println(getClass()+" Inside dowork");
		return true;
	}
}

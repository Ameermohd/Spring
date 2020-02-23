package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class Afterfinallydemoapp {
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO thedao = context.getBean("accountdao",AccountDAO.class);
		
		Account theaccount1 = new Account("John","10");
		Account theaccount2 = new Account("Doe","01");

		
		thedao.addAccount(theaccount1);
		thedao.addAccount(theaccount2);
		
		ArrayList<Account> Accountslist=null;
			
		try {
			//flag to simulate exception
		    boolean tripwire=false;
			Accountslist = thedao.findAccounts(tripwire);
		}
		catch (Exception e) {
			System.out.println("Exception in mainapp " +e);
			//e.printStackTrace();
		}
		
		context.close();
		
	}

}

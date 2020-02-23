package com.luv2code.aopdemo;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class Maindemoapp {
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO thedao = context.getBean("accountdao",AccountDAO.class);
		
		MembershipDAO shipdao = context.getBean("membershipdao",MembershipDAO.class);

		Account theaccount1 = new Account("John","10");
		Account theaccount2 = new Account("Doe","01");

		
		thedao.addAccount(theaccount1);
		thedao.addAccount(theaccount2);
		thedao.dosomestuff();
		
		thedao.setName("John");
		
		thedao.getName();
	
		System.out.println("\n-----------------------------------\n");
		System.out.println("Result from main APP"+thedao.findAccounts());
		System.out.println("-----------------------------------\n");
		
		shipdao.addAccount();
		shipdao.dowork();
		
		context.close();
		
	}

}

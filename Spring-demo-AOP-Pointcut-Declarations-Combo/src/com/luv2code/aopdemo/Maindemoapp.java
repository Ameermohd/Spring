package com.luv2code.aopdemo;

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

		Account theaccount = new Account();
		
		thedao.addAccount(theaccount);
		thedao.dosomestuff();
		
		thedao.setName("John");
		
		thedao.getName();
		
		shipdao.addAccount();
		shipdao.dowork();
		
		context.close();
		
	}

}

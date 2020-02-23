package com.luv2code.aopdemo.aspect;


import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect{
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaopackageNogettersetter()")
	public void beforeAddAdvice(JoinPoint thejoinpoint) {
		System.out.println("====>>> Executing before advice");
		
		//Get method signature from joinpoint
		MethodSignature methodsig = (MethodSignature) thejoinpoint.getSignature();
		
		System.out.println("Method : "+methodsig+"\n");
		
		Object[] args = thejoinpoint.getArgs();
		
		for(Object param:args)
		{
			System.out.print("Params :"+param+" , ");
		}
		System.out.println();
			
		
	}
	
	@AfterReturning(pointcut ="execution(* com.luv2code.aopdemo.dao.*.*(..))", 
			returning = "result"
			)
	public void AfterreturningAdvice(JoinPoint thejoinpoint , ArrayList<Account>/*String*/ result) {
		
		//Method on which advice is called
		String method = thejoinpoint.getSignature().toShortString();
		System.out.println("====>>> Executing Afterreturning advice on method : " +method);
		System.out.println("\n-----------------------------------");
		
		System.out.println("Result : "+result);
		
		System.out.println("-----------------------------------\n");
		
		//Let's postprocess the data
		
		result=convertNamaesToUpperCase(result);
		
		System.out.println("Modified result:" +result);
		
		System.out.println("-----------------------------------\n");
		
		
	}

	private ArrayList<Account> convertNamaesToUpperCase(ArrayList<Account> result) {
		
		ArrayList<Account> modresult = new ArrayList<Account>();
		for(Account temp: result)
		{
			temp.setName(temp.getName().toUpperCase());
			modresult.add(temp);
		}
	
		return modresult;
	}
	
	
	
	
	
	


}
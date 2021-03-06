package com.luv2code.aopdemo.aspect;


import java.util.ArrayList;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	public static Logger mylogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaopackageNogettersetter()")
	public void beforeAddAdvice(JoinPoint thejoinpoint) {
		mylogger.info("====>>> Executing before advice");
		
		//Get method signature from joinpoint
		MethodSignature methodsig = (MethodSignature) thejoinpoint.getSignature();
		
		mylogger.info("Method : "+methodsig+"\n");
		
		Object[] args = thejoinpoint.getArgs();
		
		for(Object param:args)
		{
			System.out.print("Params :"+param+" , ");
		}
		//mylogger.info();
			
		
	}
	
	@AfterReturning(pointcut ="execution(* com.luv2code.aopdemo.dao.*.*(..))", 
			returning = "result"
			)
	public void AfterreturningAdvice(JoinPoint thejoinpoint , ArrayList<Account>/*String*/ result) {
		
		//Method on which advice is called
		String method = thejoinpoint.getSignature().toShortString();
		mylogger.info("====>>> Executing Afterreturning advice on method : " +method);
		mylogger.info("\n-----------------------------------");
		
		mylogger.info("Result : "+result);
		
		mylogger.info("-----------------------------------\n");
		
		//Let's postprocess the data
		
		result=convertNamaesToUpperCase(result);
		
		mylogger.info("Modified result:" +result);
		
		mylogger.info("-----------------------------------\n");
		
		
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
	
	@AfterThrowing(pointcut ="execution(* com.luv2code.aopdemo.dao.*.*(..))", 
			throwing  = "exc"
			)
	public void AfterthrowingAdvice(JoinPoint thejoinpoint , Throwable exc) {
		
		//Method on which advice is called
		String method = thejoinpoint.getSignature().toShortString();
		mylogger.info("====>>> Executing Afterthrowing advice on method : " +method);
		
		//log the exception	
		mylogger.info("Exception is "+exc);
	
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void AfterfinallyAdvice(JoinPoint thejoinpoint) {
		
		//Method on which advice is called
		String method = thejoinpoint.getSignature().toShortString();
		mylogger.info("====>>> Executing Afterfinally advice on method : " +method);
	}
	
	@Around("execution(* com.luv2code.aopdemo.*.*.get*(..))")
	public Object AroundAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		
		mylogger.info("====>>> Executing Around advice on method : " +method	);
		
		long begin =System.currentTimeMillis();
		
		Object result = null;
		try {
		  result = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			mylogger.warning("Exception occured "+ e);
			//swalloing the exception main app will never know that
			//exception has happened
			//result="Nothing excitng here";
		//throw the exception
			throw e;
		
		}
		
		
		long end = System.currentTimeMillis();
		
		long duration = end-begin;
		
		mylogger.info("=======>Duration : "+duration/1000+" secs");
		
		return result;
	}
	
	


}
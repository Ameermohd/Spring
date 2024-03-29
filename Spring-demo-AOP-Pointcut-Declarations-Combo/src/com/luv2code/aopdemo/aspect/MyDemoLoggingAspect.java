package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	/*@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	//@Before("execution(* addAccount(..))")
	//@Before("execution(* addAccount(com.luv2code.aopdemo.Account))")
	//@Before("execution(* add*())")
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAdvice() {
		System.out.println("====>>> Executing before advice");
	}*/
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaopackage() {}
	
	//Pointcut for getters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..)) )")
	public void getter() {}
	
	//Pointcut for setters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..)) )")
	public void setter() {}
	
	//combine pointcut: include package excelude getters and setters
	@Pointcut("forDaopackage() && !(getter()||setter())")
	public void forDaopackageNogettersetter() {}
	
	@Before("forDaopackageNogettersetter()")
	public void beforeAddAdvice() {
		System.out.println("====>>> Executing before advice");
	}
	
	@Before("forDaopackage()")
	public void performAPIanalytics() {
		System.out.println("====>>> Executing API analytics");
	}
	

	

}
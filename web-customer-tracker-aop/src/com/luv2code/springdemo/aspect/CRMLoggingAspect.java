package com.luv2code.springdemo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
	
	public static Logger mylogger = Logger.getLogger(CRMLoggingAspect.class.getClass());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forcontroller() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void fordao() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forservice() {}
	
	//combinepointcuts
	
	@Pointcut("forcontroller()||fordao()||forservice()")
	public void combinedexp() {}
	
	@Before("combinedexp()")
	public void Beforeadvice(JoinPoint thejoinpoint) {
		
		String method = thejoinpoint.getSignature().toShortString();
		
		mylogger.info("=====>Executing @Before advice Inside "+method);
		
		//display the arguments
		
		Object[] args = thejoinpoint.getArgs();
		
		for(Object tempargs : args) {
			
			mylogger.info("=====>arguments : "+tempargs);
		}
		
	}
	
	@AfterReturning(pointcut = "combinedexp()", returning = "result")
	public void AfterReturningadvice(JoinPoint thejoinpoint,Object result) {
		
		String method = thejoinpoint.getSignature().toShortString();
		
		mylogger.info("=====>Executing @AfterReturning advice Inside "+method);
		
		mylogger.info("=====>Result "+result);
		
	}

}

package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
	
	


}
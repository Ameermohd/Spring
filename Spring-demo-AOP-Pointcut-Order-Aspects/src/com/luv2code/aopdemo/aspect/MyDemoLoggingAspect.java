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
		
	}
	
	


}
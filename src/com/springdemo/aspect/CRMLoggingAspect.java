package com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {

	//SETUP LOGGER
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//SETUD POINTCUT DECLARATION
	@Pointcut("execution(* com.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage() ")
	private void forAppFlow() {}
	
	//@BEFORE
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//DISCPLAY THE METHOD - CALLING
		String theMethod =  theJoinPoint.getSignature().toShortString();
		myLogger.info("====> in @Before: calling method " + theMethod);
		
		//GET ARGUMENTS
		Object[] args = theJoinPoint.getArgs();
		
		//DISPLAY ARGUMENTS
		for(Object tempArg : args) {
			myLogger.info("====> argument: " + tempArg);
		}
		
	}
	
	//AFTERRETURNING 
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//DISCPLAY THE METHOD - CALLING
		String theMethod =  theJoinPoint.getSignature().toShortString();
		myLogger.info("====> in @@AfterReturning: from method " + theMethod);
		
		//DISPLAY DATA RETURN
		myLogger.info("====> The result: " + theResult);
	}
	
	
	
	
	//@AFTERRETUNING
	
	
}

package com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {

	//SETUP LOGGER
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//SETUD POINTCUT DECLARATION
	@Pointcut("execution(* com.springdemo.controller.*.*.(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.springdemo.service.*.*.(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.springdemo.dao.*.*.(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage() ")
	private void forAppFlow() {}
	
	
	//@BEFORE
	
	//@AFTERRETUNING
	
	
}

package com.anurag.advices;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class LoggingThrowsAdvice implements ThrowsAdvice{
	
	Logger logger=Logger.getLogger(LoggingThrowsAdvice.class);

	public void afterThrowing
	( Method method, Object[] args, Object target,Throwable exception) throws Throwable {

		logger.error("Exception Occured While Executing : "+method.getName()+"------->>>"+exception.getMessage());
		
	}

}

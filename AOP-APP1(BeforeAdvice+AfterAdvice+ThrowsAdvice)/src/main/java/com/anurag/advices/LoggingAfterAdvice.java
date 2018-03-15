package com.anurag.advices;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LoggingAfterAdvice implements AfterReturningAdvice{
	
	Logger logger=Logger.getLogger(LoggingAfterAdvice.class);

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

		logger.info("After Executing : "+target.getClass().getName()+" Class Bussiness Method "
		+method.getName()+" Return Value : "+returnValue);
		
	}

}

package com.anurag.advices;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggingBeforeAdvice implements MethodBeforeAdvice{
	
	Logger logger=Logger.getLogger(LoggingBeforeAdvice.class);

	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		logger.info("Entered Into : "+target.getClass().getName()+" Class "+method.getName()+
				" Method With Arguments = "+args.length);
		
		
	}

}

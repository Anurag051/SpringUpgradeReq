package com.anurag.advices;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@SuppressWarnings("unused")
@Service
@Aspect
public class MyAdvices {
	private static Logger logger = Logger.getLogger(MyAdvices.class);

	@Around(value = "execution(* com.anurag.service.*.*(..))")
	public Object myAround(ProceedingJoinPoint joinPoint) {
		Object returnValue = null;
		logger.info("entered into :" + joinPoint.getSignature().getName());
		try {
			returnValue = joinPoint.proceed();
			logger.info(
					"Execution completed on :" + joinPoint.getSignature().getName() + " return value" + returnValue);
		} catch (Throwable t) {
			logger.error("Exception Occured while executing the :" + joinPoint.getSignature().getName() + " -->"
					+ t.getMessage());
		}
		return returnValue;
	}
/*
	@Before(value = "execution(* print*(..))")
	public void myBefore(JoinPoint joinPoint) {
		logger.info(" Entered into :" + joinPoint.getSignature().getName());
	}

	@AfterReturning(returning = "returnValue", pointcut = "within(com.anurag.service.CustomerServiceImpl)")

	public void myAfter(JoinPoint joinPoint, Object returnValue) {
		logger.info(
				"Execution completed on :" + joinPoint.getSignature().getName() + " return value is :" + returnValue);
	}

	@AfterThrowing(throwing = "e", pointcut = "within(com.anurag.service.CustomerServiceImpl)")
	public void myThrows(JoinPoint joinPoint, Throwable e) {
		logger.error("exception occured while executing the :" + joinPoint.getSignature().getName() + " -->"
				+ e.getMessage());
	}*/
}

package com.anurag.advices;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAroundAdvice {
	private static Logger logger=Logger.getLogger(MyAroundAdvice.class);
	public Object myAround(ProceedingJoinPoint joinPoint){
		Object returnValue=null;
		logger.info("Entered into :"+joinPoint.getSignature().getName());
		try {
			returnValue=joinPoint.proceed();
				logger.info(" Execution completed on :"+joinPoint.getSignature().getName()+" returnValue :"+returnValue);
		} catch (Throwable e) {
			logger.error("Exception occured while executing the :"+joinPoint.getSignature().getName()+" -->"+e.getMessage());
		}
		return returnValue;
	}
}
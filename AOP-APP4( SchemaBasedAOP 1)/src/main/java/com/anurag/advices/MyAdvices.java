package com.anurag.advices;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class MyAdvices{
private static Logger logger=Logger.getLogger(MyAdvices.class);
		public void before(JoinPoint joinPoint){
		
			logger.info("Entered into :"+joinPoint.getTarget().getClass().getName()+"  method :"+joinPoint.getSignature().getName()+" with args length :"+joinPoint.getArgs().length+" ");
		}
	public void afterReturning(JoinPoint joinPoint,Object returnValue){
		logger.info("Execution completed on :"+joinPoint.getTarget().getClass().getName()+"  method :"+joinPoint.getSignature().getName()+" with args length :"+joinPoint.getArgs().length+" "+" and return value is :"+returnValue);
	}
	public void myAfterThrowing(JoinPoint joinPoint,Throwable throwable){
		logger.error("Exception occured while executing the :"+joinPoint.getSignature().getName()+" -->"+throwable.getMessage());
	}
}
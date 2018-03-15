package com.anurag.advices;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
public class LoggingAroundAdvice implements MethodInterceptor {
private static Logger logger=Logger.getLogger(LoggingAroundAdvice.class);
public Object invoke(MethodInvocation invocation) {
Object returnValue=null;
      Object[] args=invocation.getArguments();
   Method method=invocation.getMethod();
      Object obj=invocation.getThis();
  logger.info("Entered into :"+method.getName()+" with args length :"+args.length+" on :"+obj.getClass().getName());
  try{      
  returnValue=invocation.proceed();
 logger.info("Execution completed on  "+method.getName()+" and return value is :"+returnValue);
  }catch(Throwable t){
logger.error("Exception Occured while executing :"+method.getName()+" --> "+t.toString());	  
  }
		return returnValue;
	}

}




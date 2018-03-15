package com.anurag.advices;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.anurag.security.AuthorizedManager;

public class MyAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object target=invocation.getThis();
		Method method=invocation.getMethod();
		Logger logger=Logger.getLogger(target.getClass().getName());
		logger.info("Entered Into : "+target.getClass().getName()+" Class "
		+method.getName()+" Method ");
		Integer count=0;
		try {
			
			AuthorizedManager manager=new AuthorizedManager();
			boolean flag=manager.isAuthorized("Bank Admin");
			if(flag==false){
				throw new IllegalAccessException("User is Not Authorized");
			}
			count=(Integer) invocation.proceed();
			if (count>0) {
				logger.info(method.getName()+" Operation Completed SuccessFully ");
			}else {
				logger.info(method.getName()+" Operation Failed");
			}
				
		} catch (Exception e) {

			logger.info("While Executing : "+method.getName()+" Exception Occured : "
			+e.getMessage());
			logger.info(method.getName()+" Operation Failed");
		}
		logger.info(method.getName()+" Method Execution Completed");
		
		return count;
	}

}

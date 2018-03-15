package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.MyAwareService;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext
				("com/anurag/config/myBean.xml");
		context.getBean("myAwareService", MyAwareService.class);
		

	}

}

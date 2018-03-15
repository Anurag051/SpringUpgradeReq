package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.service.Service;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("com/anurag/cfg/MyBean.xml");
		Service s =applicationContext.getBean("service", Service.class);
		s.serviceMethod();
	}

}

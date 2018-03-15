package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.dao.EmployeeService;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/anurag/cfg/MyBean.xml");
		EmployeeService service=context.getBean("service",EmployeeService.class);
		service.serviceMethod();
	}

}

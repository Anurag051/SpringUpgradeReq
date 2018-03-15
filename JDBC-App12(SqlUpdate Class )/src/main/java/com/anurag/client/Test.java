package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.dao.EmployeeDAO;

public class Test {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=new 
				ClassPathXmlApplicationContext("com/anurag/config/myBeans.xml");
		
		EmployeeDAO dao=context.getBean("empDao", EmployeeDAO.class);
		
		int c1=dao.deleteEmployee(105);
		System.out.println(c1+" Record(s) Deleted ");
		
		int c2=dao.updateEmployee("SOUMYA", 103);
		System.out.println(c2+" Record(s) Updated ");
	}
}
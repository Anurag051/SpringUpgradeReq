package com.anurag.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.dao.EmployeeDAO;
import com.anurag.domain.Employee;

public class Test {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=new 
				ClassPathXmlApplicationContext("com/anurag/config/myBeans.xml");
		
		EmployeeDAO dao=context.getBean("empDao", EmployeeDAO.class);
		
		Employee emp=dao.getEmployee(100);
		System.out.println(emp);
		System.out.println("============================================");
		List<Employee>list=dao.getAllEmployee();
		for (Employee employee : list) {
			System.out.println(employee);
		}

	}
}
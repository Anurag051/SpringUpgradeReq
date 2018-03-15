package com.anurag.client;

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
		Employee employee=new Employee();
		employee.setEmpNo(111);
		employee.setEname("REET");
		employee.setSalary(8596.26);
		int count=dao.createEmployee(employee);
		System.out.println(count+" Record(S) Inserted");
	}
}
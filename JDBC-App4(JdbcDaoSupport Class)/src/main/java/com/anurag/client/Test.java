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
		
		EmployeeDAO dao=context.getBean("employeeDao", EmployeeDAO.class);
		
		// Creating Employee Record(Insert)
		
		Employee employee=new Employee();
		employee.setEmpNo(1112);
		employee.setName("LUFFY");
		employee.setSalary(8523);
		int result = dao.createEmployee(employee);
		System.out.println(result+" Record(S) Inserted");
		
		
		
	}


}

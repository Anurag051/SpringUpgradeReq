package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anurag.beans.Employee;
import com.anurag.config.MyBeans;
import com.anurag.service.EmployeeService;

public class Test {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new 
				AnnotationConfigApplicationContext(MyBeans.class);
		EmployeeService service=applicationContext.getBean
				("empService",EmployeeService.class);
		Employee emp = new Employee();
		emp.setEmpNo(1001);
		emp.setName("ANURAG");
		emp.setSalary(9868.23);
		int count = service.registerEmployee(emp);
		System.out.println(count+" Record(s) Inserted ");
		
	}
	
}

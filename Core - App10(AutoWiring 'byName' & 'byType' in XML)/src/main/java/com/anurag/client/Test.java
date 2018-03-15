package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.Employee;
import com.anurag.service.EmployeeService;

public class Test {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext
																					("com/anurag/cfg/MyBean.xml");
		 EmployeeService service=context.getBean("empservice", EmployeeService.class);
		Employee emp = service.searchEmployee(100);
		if(emp != null){
			System.out.println("EmpNo\tEname\tSalary");
			System.out.println("======\t=====\t=====");
			System.out.println(emp.getEmpno()+"\t\t"+emp.getEname()+"\t"+emp.getSalary());
		}else{
			System.out.println("Employee Record Not Found");
		}
		
	}
}

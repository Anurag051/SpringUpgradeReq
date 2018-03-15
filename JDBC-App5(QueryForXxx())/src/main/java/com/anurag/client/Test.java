package com.anurag.client;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.dao.EmployeeDAO;

public class Test {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=new 
				ClassPathXmlApplicationContext("com/anurag/config/myBeans.xml");
		
		EmployeeDAO dao=context.getBean("empDao", EmployeeDAO.class);
		
		System.out.println("Employee Dept No : "+dao.getDeptNo(101));
		System.out.println("==================================");
		System.out.println("Employee Name : "+dao.getName(101));
		System.out.println("==================================");
		System.out.println("Employee Salary : "+dao.getSalary(101));
		System.out.println("==================================");
		Map<String, Object>map1=dao.getEmployee(100);
		Set<Entry<String, Object>>set=map1.entrySet();
		for (Entry<String, Object> entry : set) {
			System.out.println(entry.getKey()+" = "+entry.getValue());
		}
		System.out.println("=======================================================");
		List<Map<String, Object>>list=dao.getAllEmployee();
		for (Map<String, Object> map2 : list) {
			Set<Entry<String, Object>>set2=map2.entrySet();
			for (Entry<String, Object> entry : set2) {
				System.out.print(entry.getKey()+" = "+entry.getValue()+"\t\t");
			}
			System.out.println();
		}

	}
}
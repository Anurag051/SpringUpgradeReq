package com.anurag.client;

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
		
		Map<String, Object>map=dao.callProcedure(101);
		Set<Entry<String, Object>>set=map.entrySet();
		for (Entry<String, Object> entry : set) {
			System.out.println(entry.getKey()+" => "+entry.getValue());
		}
	}
}
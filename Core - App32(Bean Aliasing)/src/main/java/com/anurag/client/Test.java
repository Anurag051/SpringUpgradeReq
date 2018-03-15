package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.Student;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext
				("com/anurag/config/myBeans.xml");
		
		Student student1=context.getBean("std2",Student.class);
		Student student2=context.getBean("std4",Student.class);
		
		System.out.println(student1.getSid()+"\t"+student1.getName());
		System.out.println(student2.getCourse()+"\t"+student2.getCollage());

	}

}

package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.Student;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext
				("com/anurag/config/myBeans.xml");
		Student student=context.getBean("std", Student.class);
		
		System.out.println("Student ID : "+student.getSid());
		System.out.println("Student Name :"+student.getName());
		System.out.println("Student Course : "+student.getCourse().getCourseName());

	}

}

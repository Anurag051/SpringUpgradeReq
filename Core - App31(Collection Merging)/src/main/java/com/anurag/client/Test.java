package com.anurag.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.Course;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext
				("com/anurag/config/myBeans.xml");
		
		Course course=context.getBean("child",Course.class);
		
		List<String>list=course.getSubjects();
		
		for (String subjects : list) {
			System.out.println(subjects);
		}
		

	}

}

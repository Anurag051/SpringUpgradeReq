package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.Person;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext
				("com/anurag/config/myBeans.xml");
		Person child1=context.getBean("personChild1", Person.class);
		Person child2=context.getBean("personChild2", Person.class);
		Person child3=context.getBean("personChild3", Person.class);
		System.out.println("ChildBeans");
		System.out.println(child1+"\n"+child2+"\n"+child3);
		
		
		Person parent=(Person) context.getBean("personParent");
		
		System.out.println("Parent Bean :\n "+parent);
		
		

	}

}

package com.anurag.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import com.anurag.beans.Student;

@SuppressWarnings("deprecation")
public class Test {

	public static void main(String[] args) {
		// create Resource Object
		ClassPathResource resource = new ClassPathResource("/com/anurag/cfg/MyBeans.xml");
		// create the container object with resource
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		Object ob = factory.getBean("std");
		Student s = (Student) ob;// DownCasting
		System.out.println("Student ID : " + s.getSid() + "\tStudent Name : " + s.getSname());
		System.out.println("City :" + s.getAddress().getCity() + "\tState : " + s.getAddress().getState()
				+ "\tCountry : " + s.getAddress().getCountry());
	}

}

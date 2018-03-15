package com.anurag.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.anurag.beans.Student;

@SuppressWarnings("deprecation")
public class Test {

	public static void main(String[] args) {
		Resource resource=new ClassPathResource("com/anurag/cfg/MyBean.xml");
		BeanFactory factory= new XmlBeanFactory(resource);
		Student student=factory.getBean("std", Student.class);
		System.out.println(student);
	}

}

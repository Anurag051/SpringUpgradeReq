package com.anurag.client;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.anurag.beans.Collage;
import com.anurag.beans.Student;

@SuppressWarnings("deprecation")
public class Test {

	public static void main(String[] args) {
		ClassPathResource resource=new ClassPathResource("com/anurag/cfg/MyBean.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		Collage clg=factory.getBean("collage",Collage.class);
		System.out.println("Collage\t Sid \t\t Name \tAddress");
		System.out.println("======\t====\t=====\t======");
		Set<Student>student=clg.getStudents();
		for (Iterator<Student> iterator = student.iterator(); iterator.hasNext();) {
			Student std = iterator.next();
			System.out.println(clg.getCname()+"\t\t"+std.getSid()+"\t\t"+std.getSname()+"\t"+std.getSaddr());
		}
	}

}

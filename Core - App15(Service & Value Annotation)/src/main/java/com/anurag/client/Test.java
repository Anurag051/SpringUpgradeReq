package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anurag.beans.CustomerBean;
import com.anurag.beans.UserBean;

public class Test {


	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context=new AnnotationConfigApplicationContext("com.anurag.beans");
		CustomerBean customer=context.getBean("service",CustomerBean.class);
		UserBean user=customer.getUser();
		System.out.println("User ID : "+user.getId());
		System.out.println("USer Name : "+user.getName());
		System.out.println("User Mail : "+user.getMail());
		System.out.println("Order : "+customer.getOrder());
		System.out.println("Order Date : "+customer.getDate());
	}

}

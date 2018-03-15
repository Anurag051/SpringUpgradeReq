package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.service.CustomerService;

public class Test 
{
    public static void main( String[] args )
    {
       @SuppressWarnings("resource")
	ApplicationContext context=new ClassPathXmlApplicationContext
    		   									("com/anurag/config/applicationContext.xml");
       CustomerService service=context.getBean
    		   ("customerServiceProxy", CustomerService.class);
       System.out.println("Name : "+service.printName());
       System.out.println("URL : "+service.printUrl());
       try {
		service.printException();
	} catch (Exception e) {
		System.out.println(e);
	}
  }
}

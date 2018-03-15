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
    		   ("customerServiceBeforeProxy", CustomerService.class);
       System.out.println("Name : "+service.printName());
       System.out.println("URL : "+service.printUrl());
       try {
		service.printException();
	} catch (Exception e) {
		System.out.println(e);
	}
       
       CustomerService service1=context.getBean
    		   ("customerServiceAfterProxy", CustomerService.class);
       System.out.println("Name : "+service1.printName());
       System.out.println("URL : "+service1.printUrl());
       try {
		service1.printException();
	} catch (Exception e) {
		System.out.println(e);
	}
       
       CustomerService service11=context.getBean
    		   ("customerServiceThrowsProxy", CustomerService.class);
       System.out.println("Name : "+service11.printName());
       System.out.println("URL : "+service11.printUrl());
       try {
		service11.printException();
	} catch (Exception e) {
		System.out.println(e);
	}
       
       
       
    }
}

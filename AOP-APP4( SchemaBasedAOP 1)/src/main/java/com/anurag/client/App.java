package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.service.CustomerService;


public class App 
{
    public static void main( String[] args )
    {
  @SuppressWarnings("resource")
ApplicationContext context=new
		  ClassPathXmlApplicationContext("com/anurag/config/myBeans.xml");
  CustomerService cs=context.getBean("customerService",CustomerService.class);
  cs.displayName();
  cs.printURL();
  try{
  cs.printException();
  }
  catch(Exception e){
	  System.out.println(e.toString());
  }
 
    }
}

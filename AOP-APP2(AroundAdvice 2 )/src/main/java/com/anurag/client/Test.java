package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.service.AccountService;

public class Test 
{
    public static void main( String[] args )
    {
       @SuppressWarnings("resource")
	ApplicationContext context=new ClassPathXmlApplicationContext
    		   									("com/anurag/config/applicationContext.xml");
       
       AccountService service=context.getBean("accountServiceProxy", AccountService.class);
       int c1=service.deposit(1000,-500);
       if (c1==1) {
		System.out.println("Transaction SuccessFull");
	} else {
		System.out.println("Transaction Failed");
	}
       
       int c2=service.withdraw(1001, 15000);  
       if (c2==1) {
   		System.out.println("Transaction SuccessFull");
   	} else {
   		System.out.println("Transaction Failed");
   	}
       
    }
}

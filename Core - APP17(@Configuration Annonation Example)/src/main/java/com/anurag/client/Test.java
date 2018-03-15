package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anurag.beans.Service;

public class Test 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(com.anurag.cfgs.MyBeans.class);
        Service service=context.getBean("service", Service.class);
        service.serviceMethod();
    }
}

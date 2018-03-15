package com.anurag.beans;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyAwareService implements ApplicationContextAware,BeanNameAware{

	
	public void setBeanName(String name) {
		
		System.out.println("setBeanName(-) Called :- ");
		System.out.println("setBeanName : BeanName Defined in Context : "+name);
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		System.out.println("setApplicationContext(-) Called :- ");
		System.out.println("setApplicationContext : BeanDefination Names =  "+Arrays.toString(applicationContext.getBeanDefinitionNames()));
		
	}

}

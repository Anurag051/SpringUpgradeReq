package com.anurag.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class MyAwareService implements BeanFactoryAware,BeanNameAware{

	
	public void setBeanName(String name) {
		
		System.out.println("setBeanName(-) Called :- ");
		System.out.println("setBeanName : BeanName Defined in Factory : "+name);
		
	}


	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		
		System.out.println("setBeanFactory(-) Called :- ");
		System.out.println
		("setBeanFactory : BeanFactory Class =  "+beanFactory.getClass());
		
	}

}

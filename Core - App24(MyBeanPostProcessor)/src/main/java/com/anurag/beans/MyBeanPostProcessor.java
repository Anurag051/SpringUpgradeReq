package com.anurag.beans;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;



public class MyBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization(-) "+beanName);
		if (bean instanceof Cashier) {
			Cashier cashier=(Cashier) bean;
			String directory=cashier.getFilepath();
			File file=new File(directory);
			boolean b=file.mkdirs();
			if (b) {
				System.out.println("Directory Created : "+directory);
			} else {
				System.out.println("Directory Already Existing : "+directory);
			}
			
		} 
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization(-) "+beanName);
		return bean;
	}

}

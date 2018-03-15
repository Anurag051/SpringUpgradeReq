package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.WaterBean;

public class Test {

	@SuppressWarnings({"resource" })
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/anurag/config/myBean.xml");
		WaterBean waterBean=context.getBean("waterBean", WaterBean.class);
		System.out.println("Fish Name : "+waterBean.getFishBean().getFishName());
		System.out.println("Inner Bean :"+waterBean.getFishBean());
	}

}

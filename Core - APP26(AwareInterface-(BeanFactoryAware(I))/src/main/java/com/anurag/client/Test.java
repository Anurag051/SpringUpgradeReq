package com.anurag.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.anurag.beans.MyAwareService;

@SuppressWarnings("deprecation")
public class Test {

	@SuppressWarnings({ })
	public static void main(String[] args) {
		
		BeanFactory factory=new 
				XmlBeanFactory( new ClassPathResource("com/anurag/config/myBean.xml"));

		factory.getBean("myAwareService", MyAwareService.class);
		

	}

}

package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.BeanClass1;
import com.anurag.beans.BeanClass2;
import com.anurag.beans.BeanClass3;
import com.anurag.beans.BeanClass4;
import com.anurag.beans.BeanClass5;
import com.anurag.beans.BeanClass6;

public class Test {

	@SuppressWarnings({"resource" })
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext
				(new String[]{
						"com/anurag/config/Bean1.xml",
						"com/anurag/config/Bean2.xml",
						"com/anurag/config/Bean3.xml",
						"com/anurag/config/Bean4.xml"
						});
		BeanClass1 class1=context.getBean("bean1", BeanClass1.class);
		BeanClass2 class2=context.getBean("bean2", BeanClass2.class);
		BeanClass3 class3=context.getBean("bean3", BeanClass3.class);
		BeanClass4 class4=context.getBean("bean4", BeanClass4.class);
		BeanClass5 class5=context.getBean("bean5", BeanClass5.class);
		BeanClass6 class6=context.getBean("bean6", BeanClass6.class);
		
		System.out.println
		(class1.getParth1()+class2.getParth2()+class3.getParth3()+class4.getParth4()+class5.getParth5()+class6.getParth6());
		
	}

}

package com.anurag.client;
import com.anurag.beans.Student;
import org.springframework.beans.
factory.xml.XmlBeanFactory;
import org.springframework.core.
io.FileSystemResource;
@SuppressWarnings("deprecation")
public class Test {
	public static void main(String[] args){
String cfgFile=
	"D://Programing/SPRING/App1(SetterInjection + FileSystemResource)/src/main/java/com/anurag/cfg/MyBeans.xml";
FileSystemResource resource=new
	FileSystemResource(cfgFile);
XmlBeanFactory factory=new XmlBeanFactory(resource);
Student std=(Student)factory.getBean("std");
System.out.println(std.getSid());
System.out.println(std.getSname());
	}
}

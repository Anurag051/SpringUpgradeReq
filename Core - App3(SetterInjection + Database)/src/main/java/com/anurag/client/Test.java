package com.anurag.client;
import java.util.List;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.anurag.domain.Employee;
import com.anurag.service.EmployeeService;

@SuppressWarnings("deprecation")
public class Test {
public static void main(String[] args) {
String cfgFile="com/anurag/cfg/myBeans.xml";
Resource resource=new ClassPathResource(cfgFile);	
BeanFactory factory=new XmlBeanFactory(resource);
EmployeeService empService=(EmployeeService)factory.getBean("empService");
List<Employee> list=empService.getAllEmployees();
   for(Employee emp:list){  
	System.out.println(emp.getEmpno()   +" "+emp.getEname()+" "+emp.getSal());
   }
   System.out.println("-------------");
      Employee e=empService.getEmployee(103);
      if(e!=null){
      System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getSal());
      }
      else{
    System.out.println("Emp Not Found");
      }       
	}
}
package com.anurag.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	@Value("ANURAG")
private String name;
	@Value("http://facebook.com")
private String url;

	public String displayName() {
	System.out.println("Bussiness Method printName() :"+name);
		return name;
	}

	public void printURL() {
	System.out.println("Bussiness Method printURL() :"+url);	
		
	}

	public void printException() {
System.out.println("Bussiness  Method printException() ");
throw new RuntimeException("Don't sleep in the class room");
	}
}

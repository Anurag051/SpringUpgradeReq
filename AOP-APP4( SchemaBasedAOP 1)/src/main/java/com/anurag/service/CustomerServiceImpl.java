package com.anurag.service;

public class CustomerServiceImpl implements CustomerService{
private String name,url;
public void setName(String name) {
	this.name = name;
}
public void setUrl(String url) {
	this.url = url;
}

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

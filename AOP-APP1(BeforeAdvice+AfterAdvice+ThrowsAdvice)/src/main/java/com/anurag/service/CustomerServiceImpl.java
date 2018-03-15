package com.anurag.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Value("ANURAG")
	private String name;
	@Value("www.google.com")
	private String url;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String printName() {
		
		System.out.println("Bussiness Method : printName()");
		
		return name;
	}

	public String printUrl() {
		
		System.out.println("Bussiness Method : printUrl()");
		
		return url;
	}

	public String printException() throws Exception {
		
		System.out.println("Bussiness Method : printException()");
		throw new Exception("User Defined Exception");
	}

}

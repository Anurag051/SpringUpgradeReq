package com.anurag.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserBean {
	@Value("101")
	private int id;
	@Value("ANURAG")
	private String name;
	@Value("java.programer.anurag@gmail.com")
	private String mail;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMail() {
		return mail;
	}
	
}

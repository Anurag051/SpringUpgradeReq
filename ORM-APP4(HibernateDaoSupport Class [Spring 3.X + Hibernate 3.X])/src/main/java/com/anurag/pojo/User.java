package com.anurag.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private Integer userID;
	private String name;
	private String mobile;
	private String email;
	private int age;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", age=" + age
				+ "]";
	}
	
	

}

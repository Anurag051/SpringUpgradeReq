package com.anurag.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private Long userID;
	private String name;
	private String mobile;
	private String email;
	private Byte age;
	
	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
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

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	public String toString() {
		return "User [userID=" + userID + ", mobile=" + mobile + ", name=" + name + ", email=" + email + ", age=" + age
				+ "]";
	}

}

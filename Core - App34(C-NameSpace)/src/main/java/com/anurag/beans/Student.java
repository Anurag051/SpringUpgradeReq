package com.anurag.beans;

public class Student {
	
	private int sid;
	private String name;
	private Course course;
	public Student(int sid, String name, Course course) {
		super();
		this.sid = sid;
		this.name = name;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", course=" + course + "]";
	}
	
}

package com.anurag.beans;

public class Course {
	
	private String courseName;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + "]";
	}

	
	

}

package com.anurag.beans;

import java.util.List;

public class Course {
	
	private List<String>subjects;

	@Override
	public String toString() {
		return "Course [subjects=" + subjects + "]";
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
		
}

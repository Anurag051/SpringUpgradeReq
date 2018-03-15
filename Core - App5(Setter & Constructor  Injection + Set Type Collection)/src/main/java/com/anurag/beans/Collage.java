package com.anurag.beans;

import java.util.Set;

public class Collage {
	private String cname;
	private Set<Student> students;
	public Collage(String cname, Set<Student> students) {
		System.out.println("Parameterized Constructor");
		this.cname = cname;
		this.students = students;
	}
	public String getCname() {
		return cname;
	}
	public Set<Student> getStudents() {
		return students;
	}
}

/**
 * Bean Class (Student)
 */
package com.anurag.beans;

/**
 * @author ANURAG
 * @version 1.0
 */
public class Student {
	private int sid;
	private String sname;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}

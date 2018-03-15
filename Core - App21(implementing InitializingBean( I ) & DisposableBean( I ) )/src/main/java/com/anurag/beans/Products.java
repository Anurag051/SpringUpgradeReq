package com.anurag.beans;

public class Products {
	
	private int pid;
	private String pname;
	private double pprice;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + "]";
	}
	
	

}

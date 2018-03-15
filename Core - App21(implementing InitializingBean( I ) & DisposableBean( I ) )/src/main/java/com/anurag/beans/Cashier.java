package com.anurag.beans;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cashier implements InitializingBean,DisposableBean
{
	
	private double totalprice;
	private String filename,filepath;
	private PrintWriter printWriter;
	
	
	public void setFilename(String filename) {
		System.out.println("setFilename(-)");
		this.filename = filename;
	}
	
	public void setFilepath(String filepath) {
		System.out.println("setFilepath(-)");
		this.filepath = filepath;
	}
	
	
	public void openStream() {
		try {
			printWriter=new PrintWriter(filepath+"/"+filename+".txt");
			//printWriter=new PrintWriter("D:/Programing/SPRING/Product.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Exception occured at openStream() :"+e.getMessage());
		}
		
	}
	public void calculateTotalPrice(ShopingCart cart) {
		
		List<Products>list=cart.getList();
		for (Products product : list) {
			writeProductToFile(product);
			totalprice=totalprice+product.getPprice();
		}
		printWriter.println("===================================");
		printWriter.println("Total Price = "+totalprice);
		printWriter.flush();
		
	}
	private void writeProductToFile(Products product) {
		printWriter.println
		("Product ID : "+product.getPid()+"\tProduct Name : "+product.getPname()+"\tProduct"
				+ " Price : "+product.getPprice());
	}
	public void closeStream() {
		printWriter.close();
	}
	public void destroy() throws Exception {
		System.out.println("destroy()");
		closeStream();
		
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		openStream();
	}
	
	

}

package com.anurag.beans;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("cashier")
public class Cashier
{
	
	private double totalprice;
	@Value("D:/Programing/SPRING")
	private String filepath;
	@Value("Product")
	private String filename;
	PrintWriter printWriter;
	
	
	public void setFilename(String filename) {
		System.out.println("setFilename(-)");
		this.filename = filename;
	}
	
	public void setFilepath(String filepath) {
		System.out.println("setFilepath(-)");
		this.filepath = filepath;
	}
	
	@PostConstruct
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
	@PreDestroy
	public void closeStream() {
		printWriter.close();
	}
	/*
	public void destroy() throws Exception {
		System.out.println("destroy()");
		closeStream();
		
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		openStream();
	}
	*/
	

}

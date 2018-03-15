package com.anurag.beans;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class Cashier {
	private double totalPrice;
	private String fileName;
	private String filePath;
	private PrintWriter out;

	public Cashier() {
		System.out.println("0-param Constructor");
	}

	public Cashier(String fileName, String filePath) {
		System.out.println("2-param Constructor");
		this.fileName = fileName;
		this.filePath = filePath;
		openstream();
	}

	private void openstream() {
		try {
			out = new PrintWriter(filePath + fileName + ".txt");
		} catch (FileNotFoundException fe) {
			System.out.println("Exception Occured while Creating PrintWriter Obj :: " + fe.getMessage());
		}
	}

	public void calculateTotalPrice(ShopingCart cart) {
		List<Product> products = cart.getProducts();
		System.out.println(cart.getClass());
		for (Product product : products) {
			writeProductToFile(product);
			totalPrice = totalPrice + product.getPrice();
		}
		out.println("====================");
		out.println("Total Price : " + totalPrice);
		out.flush();
	}

	private void writeProductToFile(Product product) {
		out.println("Product Name : " + product.getProductName() + "\tPrice" + product.getPrice() + "\tDate : "
				+ new Date());

	}

}

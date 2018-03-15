package com.anurag.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK_STOCK")
public class BookStock {
	@Id
	@Column(name="BOOK_STOCK_ID")
	private int id;
	@Column(name="STOCK")
	private int stock;
	@Column(name="ISBN")
	private String isbn;
	//private Book book;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}

package com.anurag.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("shopingCart")
public class ShopingCart {
	@Autowired
	private List<Products>list;

	public List<Products> getList() {
		return list;
	}

	public void setList(List<Products> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ShopingCart [list=" + list + "]";
	}
	
	
}

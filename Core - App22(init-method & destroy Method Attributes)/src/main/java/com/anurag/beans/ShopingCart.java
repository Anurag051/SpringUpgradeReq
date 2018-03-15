package com.anurag.beans;

import java.util.List;

public class ShopingCart {
	
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

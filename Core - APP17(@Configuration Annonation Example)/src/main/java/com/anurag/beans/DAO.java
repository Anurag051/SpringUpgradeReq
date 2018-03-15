package com.anurag.beans;

import org.springframework.stereotype.Component;

@Component("dao")
public class DAO {
	
	public void daoMethod(){
		System.out.println("DAO : daoMethod(-)");
	}

}

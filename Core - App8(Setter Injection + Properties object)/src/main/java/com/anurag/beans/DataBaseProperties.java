package com.anurag.beans;

import java.util.Enumeration;
import java.util.Properties;

public class DataBaseProperties {
	private Properties dbproperty;

	public Properties getDbproperty() {
		return dbproperty;
	}

	public void setDbproperty(Properties dbproperty) {
		this.dbproperty = dbproperty;
	}
	public void displayDetails(){
		Enumeration<Object> enumeration=dbproperty.keys();
		while (enumeration.hasMoreElements()) {
			String id = (String) enumeration.nextElement();
			String name=dbproperty.getProperty(id);
			System.out.println(id+" => "+name);
		}
	}
}

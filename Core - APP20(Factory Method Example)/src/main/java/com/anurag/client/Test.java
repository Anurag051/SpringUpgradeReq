package com.anurag.client;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/anurag/cfg/myBeans.xml");
		Connection con=context.getBean("con",Connection.class);
		DatabaseMetaData dbmd=con.getMetaData();
		System.out.println(dbmd.getDatabaseProductVersion());
		
		ResultSetMetaData rsmd=context.getBean("rsmd", ResultSetMetaData.class);
		System.out.println(rsmd.getColumnCount());
		
		
		
		
		
		
		
		

	}

}

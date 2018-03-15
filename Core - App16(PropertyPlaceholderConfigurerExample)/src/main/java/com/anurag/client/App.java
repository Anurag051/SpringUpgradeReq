package com.anurag.client;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args ) throws SQLException
    {
      ApplicationContext context = new ClassPathXmlApplicationContext
    		  ("com/anurag/cfgs/MyBean.xml");
      DataSource ds =(DataSource) context.getBean("datasource");
      Connection con=ds.getConnection();
      DatabaseMetaData dbmd = con.getMetaData();
      System.out.println(dbmd.getDatabaseProductVersion());
    }
}

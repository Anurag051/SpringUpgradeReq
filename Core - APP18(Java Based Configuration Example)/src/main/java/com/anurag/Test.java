package com.anurag;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test 
{
    public static void main( String[] args ) throws SQLException
    {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeans.class);
        DataSource dataSource=  (DataSource) context.getBean("dataSource");
       Connection connection=dataSource.getConnection();
       DatabaseMetaData dbmd=connection.getMetaData();
       System.out.println(dbmd.getDatabaseProductVersion());
    }
}

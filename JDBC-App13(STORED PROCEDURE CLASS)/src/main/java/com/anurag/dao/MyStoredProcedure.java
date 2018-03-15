package com.anurag.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;


@SuppressWarnings("unused")
public class MyStoredProcedure extends StoredProcedure {

	/*public MyStoredProcedure (DataSource ds, String procedure) {
		super(ds, procedure);
		declareParameter(new SqlParameter("empno",Types.INTEGER));
		declareParameter(new SqlOutParameter("ename",Types.VARCHAR));
		declareParameter(new SqlOutParameter("deptname",Types.VARCHAR));
		compile();
	}*/

	public MyStoredProcedure() {
		
	}
	
}

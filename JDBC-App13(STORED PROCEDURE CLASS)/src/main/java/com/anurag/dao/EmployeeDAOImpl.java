package com.anurag.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;
@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO{
	@Autowired
	private DataSource dataSource;
	
	public Map<String, Object> callProcedure(int empNo) {
		
		MyStoredProcedure procedure=new MyStoredProcedure();
		procedure.setDataSource(dataSource);
		procedure.setSql("GET_NAME_DEPTNAME");
		procedure.declareParameter(new SqlParameter("empno",Types.INTEGER));
		procedure.declareParameter(new SqlOutParameter("ename", Types.VARCHAR));
		procedure.declareParameter(new SqlOutParameter("deptno", Types.VARCHAR));
		Map<String, Integer>inParams=new HashMap<String, Integer>();
		inParams.put("empno", empNo);
		Map<String, Object>map=procedure.execute(inParams);
		return map;
	}

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

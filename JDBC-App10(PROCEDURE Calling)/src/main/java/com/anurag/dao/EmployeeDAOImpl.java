package com.anurag.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	 private JdbcTemplate jdbcTemplate;

	public Map<String, Object> callProcedure(final int empNo) {
		
		List<SqlParameter>list=new ArrayList<SqlParameter>();
		list.add(0,new SqlParameter("empNo", Types.INTEGER));
		list.add(1,new SqlOutParameter("ename",Types.VARCHAR));
		list.add(2, new SqlOutParameter("deptName", Types.VARCHAR));
		Map<String, Object>map=jdbcTemplate.call(new CallableStatementCreator() {
			
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cst=con.prepareCall("{call GET_NAME_DEPTNAME(?,?,?)}");
				cst.setInt(1, empNo);
				cst.registerOutParameter(2, Types.VARCHAR);
				cst.registerOutParameter(3, Types.VARCHAR);
				return cst;
			}
		}, list);
		
		return map;
	}
	
}

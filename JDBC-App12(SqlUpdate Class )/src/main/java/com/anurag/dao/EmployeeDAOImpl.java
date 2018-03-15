package com.anurag.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	 private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int updateEmployee(String name,int empNo) {
		String sql="Update Emp03 set ename=? where eid=?";
		SqlUpdate update=new SqlUpdate(dataSource,sql);
		update.declareParameter(new SqlParameter(Types.VARCHAR));
		update.declareParameter(new SqlParameter(Types.INTEGER));
		int count=update.update(name, empNo);
		return count;
	}

	public int deleteEmployee(int empNo) {
		String sql="Delete from Emp03 where eid=?";
		SqlUpdate update=new SqlUpdate(dataSource,sql);
		update.declareParameter(new SqlParameter(Types.INTEGER));
		int count=update.update(empNo);
		return count;
	}

	
	
	
}

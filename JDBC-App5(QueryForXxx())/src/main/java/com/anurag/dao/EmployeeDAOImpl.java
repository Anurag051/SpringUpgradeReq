package com.anurag.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO {

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@SuppressWarnings("deprecation")
	public int getDeptNo(int empNo) {
		
		return getJdbcTemplate().queryForInt("Select dept from emp01 where eid="+empNo);
	}

	public String getName(int empNo) {
		return getJdbcTemplate().queryForObject
				("Select ename from emp01 where eid="+empNo, String.class);
	}

	public Double getSalary(int empNo) {
		return getJdbcTemplate().queryForObject
				("Select sal from emp01 where eid="+empNo, Double.class);
	}

	public Map<String, Object> getEmployee(int empNo) {
		
		return getJdbcTemplate().queryForMap
				("select eid,ename,sal,dept from emp01 where eid="+empNo);
	}

	public List<Map<String, Object>> getAllEmployee() {
		
		return getJdbcTemplate().queryForList("select eid,ename,sal,dept from emp01");
	}
	
}

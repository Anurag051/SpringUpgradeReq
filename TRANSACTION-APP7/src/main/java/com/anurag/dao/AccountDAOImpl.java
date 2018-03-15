package com.anurag.dao;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anurag.bo.AccountDetails;

public class AccountDAOImpl implements AccountDAO{
	
	private JdbcTemplate jdbcTemplate;
	Logger logger=Logger.getLogger(AccountDAO.class);

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		logger.info("Jdbc Template Is Initalized");
	}

	public int userVerification(String userName, String password) {
		logger.info("Entered Into UserVerification(-,-) Method of AccountDAOImpl class");
		
		return 0;
	}

	public int fundTransfer(int accNo, double amt) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int withdraw(int accNo, double amt) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deposit(int accNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createAccount(AccountDetails account) {
		// TODO Auto-generated method stub
		return 0;
	}

}

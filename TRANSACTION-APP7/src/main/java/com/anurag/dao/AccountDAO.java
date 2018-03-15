package com.anurag.dao;

import com.anurag.bo.AccountDetails;

public interface AccountDAO {
	
	public int userVerification(String userName,String password);
	public int fundTransfer(int accNo,double amt);
	public int withdraw(int accNo,double amt);
	public int deposit(int accNo);
	public int createAccount(AccountDetails account);
}

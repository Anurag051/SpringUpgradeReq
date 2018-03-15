package com.anurag.service;

import com.anurag.dao.AccountDAO;
import com.anurag.exception.InSufficientFundsException;
import com.anurag.exception.InvalidAmountException;

public class AccountServiceImpl implements AccountService {
	
	private AccountDAO accountDAO;
	

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public int withdraw(int accNo, double amount) {

		int count=0;
		double totalBalance=accountDAO.getBalance(accNo);
		if (totalBalance>=amount) {
			totalBalance=totalBalance-amount;
			count=accountDAO.setBalance(accNo,totalBalance);
		}else {
			throw new InSufficientFundsException("amount "+amount+" is Invalid");
		}
		return count;
	}

	public int deposit(int accNo, double amount) {
		int count=0;
		double totalBalance=accountDAO.getBalance(accNo);
		if (amount>0) {
			totalBalance=totalBalance+amount;
			count=accountDAO.setBalance(accNo,totalBalance);
		}else {
			throw new InvalidAmountException("amount "+amount+" is Invalid");
		}
		return count;
	}
}

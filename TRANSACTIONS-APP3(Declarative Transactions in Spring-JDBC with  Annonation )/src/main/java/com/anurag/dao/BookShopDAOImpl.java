package com.anurag.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("bookShopDao")

public class BookShopDAOImpl extends JdbcDaoSupport implements BookShopDAO {
	
	private static Logger logger=Logger.getLogger(BookShopDAOImpl.class);
	private static final String SQL_TO_GET_BOOK_PRICE=
																	"select price from Book where ISBN=?";
	
	private static final String SQL_DEDUCT_BALANCE=
												"UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE  Id = ?";
	
	private static final String SQL_UPDATE_BOOK_STOCK=
											"UPDATE BOOK_STOCK SET STOCK = STOCK - ? WHERE ISBN = ?";
	
	@Autowired
	public BookShopDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}



	@Transactional(readOnly=false)
	public void purchase(String isbn, int accountID, int noOfBooks) {
		
		logger.getName();
		logger.info("Entered Into purchase(-) Method of BookShopDAOImpl Class");
		
		try {
			double price=getJdbcTemplate().queryForObject
																(SQL_TO_GET_BOOK_PRICE,Double.class,isbn);
			double totalPrice = noOfBooks*price;
			getJdbcTemplate().update(SQL_DEDUCT_BALANCE, totalPrice,accountID);
			getJdbcTemplate().update(SQL_UPDATE_BOOK_STOCK, noOfBooks,isbn);
			logger.info(noOfBooks+" No Of Book(s) Purchased SuccessFully");
			logger.info(totalPrice+" Amount Is Deducted From your Account");
			System.out.println("Ur Transaction Is Successfully Completed");
			
		} catch (Exception e) {
			logger.error("Error Occured in Purchase Method Of BookShopImpl Class : "+e.getMessage());
		}//catch
		logger.info("End of purchase(-) Method of BookShopDAOImpl Class");
	}//method
}//class

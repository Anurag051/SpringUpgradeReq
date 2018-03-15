package com.anurag.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.anurag.pojo.Book;


public class BookShopDAOImpl  implements BookShopDAO {
	
	private static Logger logger=Logger.getLogger(BookShopDAOImpl.class);
	private PlatformTransactionManager transactionManager;
	private HibernateTemplate hibernateTemplate;
	
	private static final String HQL_TO_GET_BOOK_PRICE=
														"FROM Book WHERE isbn=:unique";
	
	private static final String HQL_DEDUCT_BALANCE=
					"UPDATE Account SET BALANCE = BALANCE - ? WHERE  accountID = ?";
	
	private static final String HQL_UPDATE_BOOK_STOCK=
						"UPDATE BookStock SET stock = stock - ? WHERE isbn = ?";
	

	@SuppressWarnings("unchecked")
	
	public void purchase(String isbn, int accountID, int noOfBooks) {
		
		TransactionDefinition definition=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(definition);
		
		try {
			List<Book>list=(List<Book>) hibernateTemplate.findByNamedParam
					(HQL_TO_GET_BOOK_PRICE,"unique", isbn);
			Book book=list.get(0);
			double cost=book.getPrice();
			System.out.println("Book Name : "+book.getBookName()+"Book Price : "+book.getPrice());
			double totalCost = noOfBooks*cost;
			int cnt=hibernateTemplate.bulkUpdate
													(HQL_DEDUCT_BALANCE, totalCost,accountID);
			if (cnt!=0) {
				System.out.println
				(totalCost+" Rs amount Deducted From Account for "+noOfBooks+" books");
			} else {
				System.out.println("Amount Transaction Failed");
			}
			
			int count=hibernateTemplate.bulkUpdate
													(HQL_UPDATE_BOOK_STOCK, noOfBooks,isbn);
			if (count!=0) {
				System.out.println(noOfBooks+" No of Books Is Dispatched To ur Address");
			} 
			transactionManager.commit(status);
			logger.info(noOfBooks+" No Of Book(s) Purchased SuccessFully");
			logger.info(totalCost+" Amount Is Deducted From your Account");
			
		} catch (Exception e) {
			transactionManager.rollback(status);
			logger.error("Error Occured in Purchase Method Of BookShopImpl Class : "+e.toString());
		}//catch
		
	}//method

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}//class

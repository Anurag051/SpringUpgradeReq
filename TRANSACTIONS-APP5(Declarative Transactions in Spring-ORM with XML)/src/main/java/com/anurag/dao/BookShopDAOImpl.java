package com.anurag.dao;

import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.anurag.pojo.Book;


public class BookShopDAOImpl  implements BookShopDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	private static final String HQL_TO_GET_BOOK_PRICE=
														"FROM Book WHERE isbn=:unique";
	
	private static final String HQL_DEDUCT_BALANCE=
					"UPDATE Account SET BALANCE = BALANCE - ? WHERE  accountID = ?";
	
	private static final String HQL_UPDATE_BOOK_STOCK=
						"UPDATE BookStock SET stock = stock - ? WHERE isbn = ?";
	

	@SuppressWarnings("unchecked")

	public void purchase(String isbn, int accountID, int noOfBooks) {
		
			//System.out.println("Entred Into Purchase Method ");
		
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
	
	}//method

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}//class

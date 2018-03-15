package com.anurag.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.anurag.pojo.Accounts;

public class AccountDAOImpl implements AccountDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public double getBalance(int accNo) {
		String sql ="From Accounts where accNo = "+accNo;
		List<Accounts>list=(List<Accounts>) hibernateTemplate.find(sql);
		Accounts account=list.get(0);
		Double bal=account.getBalance();
		return bal;
	}

	public int setBalance(final int accNo, final double totalBalance) {
		
		int count=hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException {
				
				String sql= "Update Accounts set balance = :new_bal where accNo=:no ";
				Query query=session.createQuery(sql);
				query.setParameter("new_bal", totalBalance);
				query.setParameter("no", accNo);
				int cnt=query.executeUpdate();
				return cnt;
			}
		});
		return count;
	}

}

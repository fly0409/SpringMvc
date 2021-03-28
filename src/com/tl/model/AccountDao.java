package com.tl.model;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("accountDao")
public class AccountDao {
	@Autowired
	private Account account;
	
	@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public AccountDao() {
	}

	public Account findById(int accountid) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Account acc = session.get(Account.class, accountid);		
		return acc;		
	}
	
	public boolean checkLogin(Account account) {
		String hql="from Account where username=:user and userpwd=:pwd";
		Session session = sessionFactory.getCurrentSession();
		Query<Account> qry = session.createQuery(hql,Account.class);
		qry.setParameter("user", account.getUsername());
		qry.setParameter("pwd", account.getUserpwd());
		Account acc =qry.uniqueResult();
		
		if(acc!=null) {
			return true;
		}else {
			return false;
		}
		
	}
	
}

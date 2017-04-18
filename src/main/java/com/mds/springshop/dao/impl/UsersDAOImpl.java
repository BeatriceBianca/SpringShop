package com.mds.springshop.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Users;

@Transactional
public class UsersDAOImpl implements UsersDAO {

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 
	 public Users findUserByEmail(String email) {
		 Session session = sessionFactory.getCurrentSession();
	     Criteria crit = session.createCriteria(Users.class);
	     crit.add(Restrictions.eq("email", email));
	     return (Users) crit.uniqueResult();
	    }
	
}
package com.mds.springshop.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Users;
import com.mds.springshop.model.UsersInfo;

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
	 public UsersInfo findUserInfo(String email){
		 Users user=this.findUserByEmail(email);
		 if(user==null)
			 return null;
		 return new UsersInfo(user.getLastName(),user.getFirstName(),user.getEmail(),user.getPassword(),user.getPhone(),user.getAddress(),user.getRole());
	 }
	 public void save(UsersInfo userInfo)
	 {
		 String email=userInfo.getEmail();
		 Users user=null;
		 boolean isNew=false;
		 if(email!=null)
		 {
			 user=this.findUserByEmail(email);
		 }
		 if(user==null)
		 {
			 isNew=true;
			 user=new Users();
		 }
		 user.setLastName(userInfo.getLastName());
		 user.setFirstName(userInfo.getFirstName());
		 user.setEmail(userInfo.getEmail());
		 user.setPassword(userInfo.getPassword());
		 user.setPhone(userInfo.getPhone());
		 user.setAddress(userInfo.getAddress());
		 user.setRole(userInfo.getRole());
		 
		 if(isNew){
			 this.sessionFactory.getCurrentSession().persist(user);
		 }
		 this.sessionFactory.getCurrentSession().flush();
	 }
}
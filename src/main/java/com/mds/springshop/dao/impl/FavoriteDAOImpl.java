package com.mds.springshop.dao.impl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mds.springshop.dao.FavoriteDAO;
import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Favorites;
import com.mds.springshop.model.FavoritesInfo;

@Transactional
@Component
public class FavoriteDAOImpl implements FavoriteDAO{
	
	@Autowired
	ProductsDAO product;
	
	@Autowired
	UsersDAO user;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addFavorite(int favoriteId, int userId){
		
		Favorites fav = new Favorites();
		
		fav.setProductId(favoriteId);
		fav.setUserId(userId);
		
		this.sessionFactory.getCurrentSession().persist(fav);
		this.sessionFactory.getCurrentSession().flush();
	}

	public ArrayList<FavoritesInfo> getFavoritesByUser(int userId) {
	    	
	    	String sql;
	    
	    	sql = "Select new " + FavoritesInfo.class.getName() //
	                + "(f.productId, f.userId) " + " from "//
	                + Favorites.class.getName() + " f " 
	                + " where f.userId = " + userId;

	    	System.out.print(sql);
	    	Session session = sessionFactory.getCurrentSession();
	   	 
	    	Query query = session.createQuery(sql);
	    	
	    	ArrayList<FavoritesInfo> product = (ArrayList<FavoritesInfo>) query.list();
	    	
	    	return product;
	    }
}

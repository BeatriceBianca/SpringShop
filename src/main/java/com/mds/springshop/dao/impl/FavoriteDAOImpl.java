package com.mds.springshop.dao.impl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mds.springshop.dao.FavoriteDAO;
import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Cos;
import com.mds.springshop.entity.Favorites;
import com.mds.springshop.entity.Products;
import com.mds.springshop.entity.Users;
import com.mds.springshop.model.CosInfo;
import com.mds.springshop.model.FavoritesInfo;

@Transactional
@Component
public class FavoriteDAOImpl implements FavoriteDAO{
	
	@Autowired
	private ProductsDAO product;
	
	@Autowired
	private UsersDAO user;
	
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

	    	Session session = sessionFactory.getCurrentSession();
	   	 
	    	Query query = session.createQuery(sql);
	    	
	    	ArrayList<FavoritesInfo> product = (ArrayList<FavoritesInfo>) query.list();
	    	return product;
	    }
	
	public void deleteFavProdId(int idProd){
		UserDetails currentUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users userInfo;
		userInfo = user.findUserByEmail(currentUser.getUsername());
    	Session session=this.sessionFactory.getCurrentSession();
    	
    	Query query=session.createQuery("delete Favorites where productId=:idP and userId = :usernameParam");
    	query.setParameter("idP",idProd);
    	query.setParameter("usernameParam",userInfo.getId());
    	query.executeUpdate();
    	session.flush();
    }
	
}

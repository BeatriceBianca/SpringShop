package com.mds.springshop.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.entity.Products;
import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;

@Transactional
@Component
public class ProductsDAOImpl implements ProductsDAO {

	private volatile int categoryType = 5;
	
	@Autowired
    private SessionFactory sessionFactory;
	
    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, int category) {

    	String sql;
    	if (category == 5) {
    		sql = "Select new " + ProductInfo.class.getName() //
                    + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId, p.id) " + " from "//
                    + Products.class.getName() + " p " 
                    + " where p.status = 1";
    	} else {
    		sql = "Select new " + ProductInfo.class.getName() //
                    + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId, p.id) " + " from "//
                    + Products.class.getName() + " p " 
                    + " where p.status = 1 and p.categoryId = " + category;
    	}
    	
    	Session session = sessionFactory.getCurrentSession();
    	 
    	Query query = session.createQuery(sql);
    	
    	return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }
    
    public ProductInfo getProductById(int id) {
    	
    	String sql;
    	
    	sql = "Select new " + ProductInfo.class.getName() //
                + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId, p.id) " + " from "//
                + Products.class.getName() + " p " 
                + " where p.id = " + id;
    	
    	Session session = sessionFactory.getCurrentSession();
   	 
    	Query query = session.createQuery(sql);
    	
    	ProductInfo product = (ProductInfo) query.list().get(0);
    	
    	return product;
    }
}
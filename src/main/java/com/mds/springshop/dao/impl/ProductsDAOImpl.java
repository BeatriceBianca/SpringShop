package com.mds.springshop.dao.impl;

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

	@Autowired
    private SessionFactory sessionFactory;

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {

    	String sql = "Select new " + ProductInfo.class.getName() //
                + "(p.name, p.productsLeftInStock, p.price, p.status) " + " from "//
                + Products.class.getName() + " p " 
                + " where p.status = 1";
    	
    	Session session = sessionFactory.getCurrentSession();
    	 
    	Query query = session.createQuery(sql);
    	
    	return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }
}
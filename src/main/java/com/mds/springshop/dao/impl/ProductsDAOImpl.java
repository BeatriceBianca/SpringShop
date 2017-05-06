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

	private volatile int categoryType = 5;
	private long priceMin=0;
	private long priceMax=0;
	private int status;
	@Autowired
    private SessionFactory sessionFactory;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(long priceMin) {
		this.priceMin = priceMin;
	}

	public long getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(long priceMax) {
		this.priceMax = priceMax;
	}
    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,//
    		int category,long minPrice,long maxPrice,int status) {

    	String sql;
    	if (category == 5) {
    		sql = "Select new " + ProductInfo.class.getName() //
                    + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId) " + " from "//
                    + Products.class.getName() + " p ";
            if(status==10)
            	sql+= " where p.status = 1 or p.status = 0";
            else
            	sql+= " where p.status = "+status;
    		if(minPrice!=0) sql+=" and p.price >= "+minPrice;
    		if(maxPrice!=0) sql+=" and p.price <= "+maxPrice;
    	} else {
    		sql = "Select new " + ProductInfo.class.getName() //
                    + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId) " + " from "//
                    + Products.class.getName() + " p "; 
//                    + " where p.status = "+status+" and p.categoryId = " + category;
    		if(status==10)
              	sql+= " where p.status = 1 or p.status = 0";
            else
               	sql+= " where p.status = "+status;
    		if(minPrice!=0) sql+=" and p.price >= "+minPrice;
    		if(maxPrice!=0) sql+=" and p.price <= "+maxPrice;
    	}
    	
    	Session session = sessionFactory.getCurrentSession();
    	 
    	Query query = session.createQuery(sql);
    	
    	return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }
}
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

import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Cos;
import com.mds.springshop.entity.Products;
import com.mds.springshop.entity.Users;
import com.mds.springshop.model.CosInfo;
import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;

@Transactional
@Component
public class ProductsDAOImpl implements ProductsDAO {

	private volatile int categoryType = 5;
	private long priceMin=0;
	private long priceMax=0;
	private int Stock;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
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
    
    public void addProduct(ProductInfo productInfo,Users user){
    	Products product=new Products();
    	product.setName(productInfo.getName());
    	product.setDescription(productInfo.getDescription());
    	product.setPrice(productInfo.getPrice());
    	product.setProductsLeftInStock(productInfo.getProductsLeftInStock());
    	product.setCategoryId(productInfo.getCategory());
    	product.setStatus(0);
    	product.setSupplierId(user);
    	Session session=this.sessionFactory.getCurrentSession();
    	session.save(product);
    	session.flush();
    }
    
    public void updateCart(int idProd,int cantitate){
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Session session=this.sessionFactory.getCurrentSession();
    	CosInfo cosInfo=this.findProductInCart(idProd, userDetails.getUsername());
    	Cos cartProducts=session.get(Cos.class,cosInfo.getIdCos());
    	cartProducts.setCantitate(cantitate);
    	session.update(cartProducts);
    	session.flush();
    }
    public void deleteCartProdId(int idProd){
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query query=session.createQuery("delete Cos where idProd=:idP and userEmail = :usernameParam");
    	query.setParameter("idP",idProd);
    	query.setParameter("usernameParam",userDetails.getUsername());
    	query.executeUpdate();
    	session.flush();
    }
    
    public PaginationResult<CosInfo> queryCartProducts(int prodId,int page, int maxResult, int maxNavigationPage) {
    	ProductInfo product=null;
    	if(prodId!=0)
    		product=this.getProductById(prodId);
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Session session=this.sessionFactory.getCurrentSession();
    	if(product!=null){
    		Cos cartProducts;
    		if(this.findProductInCart(prodId, userDetails.getUsername())!=null){
    			CosInfo cosInfo=this.findProductInCart(prodId, userDetails.getUsername());
    			cartProducts=session.get(Cos.class,cosInfo.getIdCos());
    			cartProducts.setCantitate(cartProducts.getCantitate()+1);
    			session.update(cartProducts);
    		}
    		else{
	    		cartProducts=new Cos();
	    		cartProducts.setIdProd(product.getId());
	    		cartProducts.setDenumireProd(product.getName());
	    		cartProducts.setPretProd(product.getPrice());
	    		cartProducts.setCantitate(1);
	    		cartProducts.setUserEmail(userDetails.getUsername());
	    		session.save(cartProducts);
    		}
    	}
    	String sql="Select new " + CosInfo.class.getName() + "(p.userEmail,p.idProd,"
    			+ "p.denumireProd,p.pretProd,p.idCos,p.cantitate) " + " from " + Cos.class.getName() + " p "
    			+ " where p.userEmail = :usernameParam";
    	Query query=session.createQuery(sql);
    	query.setParameter("usernameParam",userDetails.getUsername());
    	session.flush();
    	return new PaginationResult<CosInfo>(query, page, maxResult, maxNavigationPage);
    }
    
    public PaginationResult<ProductInfo> queryProductsFromOffers(int page, int maxResult, int maxNavigationPage){
    	String SQL = "Select new " + ProductInfo.class.getName() //
                + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId, p.id) " + " from "//
                + Products.class.getName() + " p "
                + " where p.status = 0 ";
    	Session session = sessionFactory.getCurrentSession();
    	Query query = session.createQuery(SQL);
    	return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,//
    		int category,long minPrice,long maxPrice,int stock) {

    	String sql;
    	if (category == 5) {
    		sql = "Select new " + ProductInfo.class.getName() //
                    + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId, p.id) " + " from "//
                    + Products.class.getName() + " p "
                    + " where p.status = 1 ";
    		if(minPrice!=0) sql+=" and p.price >= "+minPrice;
    		if(maxPrice!=0) sql+=" and p.price <= "+maxPrice;
    		if(stock!=0) sql+=" and p.productsLeftInStock > 0 ";
    		else sql+=" and p.productsLeftInStock >= 0 ";
    	} else {
    		sql = "Select new " + ProductInfo.class.getName() //
                    + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId, p.id) " + " from "//
                    + Products.class.getName() + " p "
                    + " where p.status = 1 and p.categoryId = " + category; 
    		if(minPrice!=0) sql+=" and p.price >= "+minPrice;
    		if(maxPrice!=0) sql+=" and p.price <= "+maxPrice;
    		if(stock!=0) sql+=" and p.productsLeftInStock > 0 ";
    		else sql+=" and p.productsLeftInStock >= 0 ";
    	}
    	
    	Session session = sessionFactory.getCurrentSession();
    	 
    	Query query = session.createQuery(sql);
    	
    	return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }
    
    public CosInfo findProductInCart(int idProd,String userEmail){
    	String sql;
    	sql="Select new " + CosInfo.class.getName()+"(p.userEmail,p.idProd,"
    			+ "p.denumireProd,p.pretProd,p.idCos,p.cantitate) " + " from " + Cos.class.getName() + " p "
    			+ " where p.userEmail = :usernameParam and p.idProd=:idProdParam";
    	Session session = sessionFactory.getCurrentSession();
    	Query query=session.createQuery(sql);
    	query.setParameter("usernameParam",userEmail);
    	query.setParameter("idProdParam",idProd);
    	CosInfo cosProduct=null;
    	if(query.list().size()!=0)
			cosProduct=(CosInfo)query.list().get(0);
    	return cosProduct;
    }
    public void acceptOffer(int idProd){
    	Session session = sessionFactory.getCurrentSession();
    	Products product=(Products)session.get(Products.class,idProd);
    	product.setStatus(1);
    	session.update(product);
    	session.flush();
    }
    public void refuseOffer(int idProd){
    	Session session = sessionFactory.getCurrentSession();
    	Products product=(Products)session.get(Products.class,idProd);
    	session.delete(product);
    	session.flush();
    }
    public ProductInfo getProductById(int id) {
    	
    	String sql;
    	
    	sql = "Select new " + ProductInfo.class.getName() //
                + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId, p.id, p.description) " + " from "//
                + Products.class.getName() + " p " 
                + " where p.id = " + id;
    	
    	Session session = sessionFactory.getCurrentSession();
   	 
    	Query query = session.createQuery(sql);
    	
    	ProductInfo product = (ProductInfo) query.list().get(0);
    	
    	return product;
    }
    
    public ArrayList<ProductInfo> getAllProducts() {

    	String sql;
    		sql = "Select new " + ProductInfo.class.getName() //
                    + "(p.name, p.productsLeftInStock, p.price, p.status, p.categoryId, p.id) " + " from "//
                    + Products.class.getName() + " p "
                    + " where p.status = 1 ";
    	
    	Session session = sessionFactory.getCurrentSession();
    	 
    	Query query = session.createQuery(sql);
    	
    	ArrayList<ProductInfo> product = (ArrayList<ProductInfo>) query.list();
    	
    	return product;
    }
    
    public void updateProduct(int id, ProductInfo productInfo)
	 {
		 String sql = "update Products ";
		 if (productInfo.getName() != "" ) {
			 sql += "set product_name = '" + productInfo.getName() + "'";
			 if (productInfo.getDescription() != "") {
				 sql += ", description = '" + productInfo.getDescription() + "'";
			 }
			 if (productInfo.getPrice() != 0) {
				 sql += ", price = " + productInfo.getPrice();
			 }
		 } else {
			 if (productInfo.getDescription() != "") {
				 sql += "set description = '" + productInfo.getDescription() + "'";
				 if (productInfo.getPrice() != 0) {
					 sql += ", price = " + productInfo.getPrice();
				 }
			 } else {
				 if (productInfo.getPrice() != 0) {
					 sql += "set price = " + productInfo.getPrice();
				 }
			 }
		 }

		 
	 	 sql += " where product_id = " + id;
		 
		 Session session = sessionFactory.getCurrentSession();
		 Query query = session.createQuery(sql);
	   	 query.executeUpdate();
	 }

}
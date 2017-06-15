package com.mds.springshop.dao;

import java.util.ArrayList;

import com.mds.springshop.entity.Products;
import com.mds.springshop.entity.Users;
import com.mds.springshop.model.CosInfo;
import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;
 
public interface ProductsDAO {
	
	int getCategoryType();
	
    void setCategoryType(int categoryType);
    public long getPriceMin();
    public void setPriceMin(long priceMin);
    public long getPriceMax();
    public void setPriceMax(long priceMax);
    public int getStock();
    public void setStock(int stock);
    
    public PaginationResult<ProductInfo> queryProducts(int page,
            int maxResult, int maxNavigationPage, int category,long minPrice,long maxPrice,int stock);
    public PaginationResult<CosInfo> queryCartProducts(int prodId,int page, int maxResult, int maxNavigationPage);
    public ProductInfo getProductById(int id);   
    public ArrayList<ProductInfo> getAllProducts();
    public void updateProduct(int id, ProductInfo productInfo);
    public void deleteCartProdId(int idProd);
    public void updateCart(int idProd,int cantitate);
    public boolean testProductStock(int idProd,int stock);
    public void cartFinalization();
    public void addProduct(ProductInfo productInfo,Users user);
    public PaginationResult<ProductInfo> queryProductsFromOffers(int page, int maxResult, int maxNavigationPage);
    public void acceptOffer(int idProd);
    public void refuseOffer(int idProd);
    public CosInfo findProductInCart(int idProd,String userEmail);
}
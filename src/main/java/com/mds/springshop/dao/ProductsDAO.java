package com.mds.springshop.dao;

import java.util.ArrayList;

import com.mds.springshop.entity.Products;
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
    
    public ProductInfo getProductById(int id);
    
    public ArrayList<ProductInfo> getAllProducts();
    
    public void updateProduct(ProductInfo productInfo);
 
}
package com.mds.springshop.dao;

import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;
 
public interface ProductsDAO {
	
	int getCategoryType();
	
    void setCategoryType(int categoryType);
    public long getPriceMin();
    public void setPriceMin(long priceMin);
    public long getPriceMax();
    public void setPriceMax(long priceMax);
    public int getStatus();
    public void setStatus(int status);
    public PaginationResult<ProductInfo> queryProducts(int page,
            int maxResult, int maxNavigationPage, int category,long minPrice,long maxPrice,int status);
 
}
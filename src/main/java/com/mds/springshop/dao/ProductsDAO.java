package com.mds.springshop.dao;

import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;
 
public interface ProductsDAO {
	
	int getCategoryType();

    void setCategoryType(int categoryType);
 
    public PaginationResult<ProductInfo> queryProducts(int page,
            int maxResult, int maxNavigationPage, int category);
 
}
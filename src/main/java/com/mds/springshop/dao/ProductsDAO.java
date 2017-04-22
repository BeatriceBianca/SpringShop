package com.mds.springshop.dao;

import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;
 
public interface ProductsDAO {
 
    public PaginationResult<ProductInfo> queryProducts(int page,
            int maxResult, int maxNavigationPage);
 
}
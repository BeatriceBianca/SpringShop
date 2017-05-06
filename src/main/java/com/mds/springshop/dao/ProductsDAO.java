package com.mds.springshop.dao;

import com.mds.springshop.entity.Products;
import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;
 
public interface ProductsDAO {
	
	int getCategoryType();

    void setCategoryType(int categoryType);
 
    public PaginationResult<ProductInfo> queryProducts(int page,
            int maxResult, int maxNavigationPage, int category);
    
    public ProductInfo getProductById(int id);
    
    public Products findProductById(int id);
    
    public void updateProduct(ProductInfo productInfo);
 
}
package com.mds.springshop.model;

import com.mds.springshop.entity.Products;


 
public class ProductInfo {
	private String name;
	private int productsLeftInStock;
	private long price;
	private int status;
	private int category;
	private long minPrice;
	private long maxPrice;
	
    public long getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(long minPrice) {
		this.minPrice = minPrice;
	}

	public long getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(long maxPrice) {
		this.maxPrice = maxPrice;
	}

	private boolean newProduct=false;
 
    public ProductInfo() {
    }
 
    public ProductInfo(Products product) {
        this.name = product.getName();
        this.productsLeftInStock = product.getProductsLeftInStock();
        this.price = product.getPrice();
        this.status = product.getStatus();
        this.category = product.getCategoryId();
    }
 
    public ProductInfo(String name, int productsLeftInStock, long price, int status, int category) {
        this.name = name;
        this.productsLeftInStock = productsLeftInStock;
        this.price = price;
        this.status = status;
        this.category = category;
    }
 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductsLeftInStock() {
		return productsLeftInStock;
	}

	public void setProductsLeftInStock(int productsLeftInStock) {
		this.productsLeftInStock = productsLeftInStock;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}
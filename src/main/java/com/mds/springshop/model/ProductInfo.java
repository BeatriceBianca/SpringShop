package com.mds.springshop.model;

import com.mds.springshop.entity.Products;


 
public class ProductInfo {
	private String name;
	private int productsLeftInStock;
	private int price;
 
    private boolean newProduct=false;
 
    public ProductInfo() {
    }
 
    public ProductInfo(Products product) {
        this.name = product.getName();
        this.productsLeftInStock = product.getProductsLeftInStock();
        this.price = product.getPrice();
    }
 
    public ProductInfo(String name, int productsLeftInStock, int price) {
        this.name = name;
        this.productsLeftInStock = productsLeftInStock;
        this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}
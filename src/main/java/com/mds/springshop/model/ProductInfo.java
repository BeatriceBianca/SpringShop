package com.mds.springshop.model;

import com.mds.springshop.entity.Categories;
import com.mds.springshop.entity.Products;


 
public class ProductInfo {
	private String name;
	private int productsLeftInStock;
	private int price;
	private int status;
	private Categories category;
	private int id;
 
    private boolean newProduct=false;
 
    public ProductInfo() {
    }
 
    public ProductInfo(Products product) {
        this.name = product.getName();
        this.productsLeftInStock = product.getProductsLeftInStock();
        this.price = product.getPrice();
        this.status = product.getStatus();
        this.category = product.getCategoryId();
        this.id = product.getId();
    }
 
    public ProductInfo(String name, int productsLeftInStock, int price, int status, Categories category, int id) {
        this.name = name;
        this.productsLeftInStock = productsLeftInStock;
        this.price = price;
        this.status = status;
        this.category = category;
        this.id = id;
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
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
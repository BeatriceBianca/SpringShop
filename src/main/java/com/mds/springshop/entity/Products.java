package com.mds.springshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Products implements Serializable {
	private static final long serialVersionUID = -2054386655979281965L;
	
	private int id;
	private String name;
	private int productsLeftInStock;
	private long price;
	private int categoryId;
	private Users supplierId;
	private int status;
	private String description;
	
	@Id
	@Column(name = "product_id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "category_id")
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_ID", nullable = false, //
		foreignKey = @ForeignKey(name = "products_user_fk") )
		    public Users getSupplierId() {
		        return supplierId;
		    }
		 
		    public void setSupplierId(Users supplierId) {
		        this.supplierId = supplierId;
		    }
	
	@Column(name = "product_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "products_left_in_stock")
	public int getProductsLeftInStock() {
		return productsLeftInStock;
	}
	
	public void setProductsLeftInStock(int productsLeftInStock) {
		this.productsLeftInStock = productsLeftInStock;
	}
	
	@Column(name = "price")
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "product_description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
package com.mds.springshop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {
	private static final long serialVersionUID = -2054386655979281966L;
	
	private int id;
	private Date orderDate;
	private int quantity;
	private int history;
	private Products productId;
	private Users userId;
	
	@Id
	@Column(name = "order_id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "order_date")
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "history")
	public int getHistory() {
		return history;
	}
	
	public void setHistory(int history) {
		this.history = history;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false, //
		foreignKey = @ForeignKey(name = "product_fk") )
			public Products getProductId() {
				return productId;
			}
			public void setProductId(Products productId) {
				this.productId = productId;
			}
	    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, //
		foreignKey = @ForeignKey(name = "user_fk") )
		    public Users getUserId() {
		        return userId;
		    }
		 
		    public void setUserId(Users UserId) {
		        this.userId = userId;
		    }
	
	
}
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
@Table(name = "REVIEW")
public class Review implements Serializable {
	private static final long serialVersionUID = -2054386655979281964L;
	
	private int id;
	private int rating;
	private String commentary;
	private Products productId;
	private Users userId;
	
	@Id
	@Column(name = "review_id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "rating")
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Column(name = "commentary")
	public String getCommentary() {
		return commentary;
	}
	
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false, //
		foreignKey = @ForeignKey(name = "review_product_fk") )
			public Products getProductId() {
				return productId;
			}
			public void setProductId(Products productId) {
				this.productId = productId;
			}
	    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, //
		foreignKey = @ForeignKey(name = "review_user_fk") )
		    public Users getUserId() {
		        return userId;
		    }
		 
		    public void setUserId(Users userId) {
		        this.userId = userId;
		    }
	
}
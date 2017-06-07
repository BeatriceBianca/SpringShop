package com.mds.springshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mds.springshop.model.FavoritesInfo;

@Entity
@Table(name = "FAVORITES")
public class Favorites implements Serializable {
	private static final long serialVersionUID = -2054386655979281967L;
	
	private int id;
	private int productId;
	private int userId;
	
	public Favorites () {
		
	}
	
	public Favorites(FavoritesInfo fav) {
		this.productId = fav.getProductId();
		this.userId = fav.getUserId();
	}
	
	@Id
	@Column(name = "favorite_id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "product_id")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	
}
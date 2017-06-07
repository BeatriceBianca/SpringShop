package com.mds.springshop.model;

import com.mds.springshop.entity.Favorites;

public class FavoritesInfo {
	
	public int productId;
	public int userId;
	
	public FavoritesInfo() {
	}
	
	public FavoritesInfo(Favorites fav){
		productId = fav.getProductId();
		userId = fav.getUserId();
	}
	
	public FavoritesInfo (int productId, int userId) {
		this.userId = userId;
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
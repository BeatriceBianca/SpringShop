package com.mds.springshop.dao;

import java.util.ArrayList;

import com.mds.springshop.model.FavoritesInfo;
 
public interface FavoriteDAO {
	
	public void addFavorite(int favoriteId, int userId);
	
	public ArrayList<FavoritesInfo> getFavoritesByUser(int userId);
	
}
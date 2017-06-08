package com.mds.springshop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mds.springshop.dao.FavoriteDAO;
import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Favorites;
import com.mds.springshop.entity.Users;
import com.mds.springshop.model.FavoritesInfo;
import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;

@Controller
public class FavoritesController {
	
	private int favoriteId;
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	@Autowired
	private ProductsDAO productDAO;
	
	@Autowired
	private UsersDAO userDAO;


	@RequestMapping(value = { "/favorite" }, method = RequestMethod.GET)
    public String getFavoritePage(Model model,
    		@RequestParam(value = "page", defaultValue = "1") int page) {
 
		UserDetails currentUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users user;
		user = userDAO.findUserByEmail(currentUser.getUsername());
		favoriteDAO.addFavorite(favoriteId, user.getId());
		
		ArrayList<ProductInfo> favorite = new ArrayList<ProductInfo>();
		
		ArrayList<ProductInfo> listOfProducts = productDAO.getAllProducts();
		ArrayList<FavoritesInfo> listOfFavorites = favoriteDAO.getFavoritesByUser(user.getId());
		
		for( int i = 0; i < listOfFavorites.size(); i++ ){
			for( int j = 0; j < listOfProducts.size(); j++ ) {
				if ( listOfFavorites.get(i).getProductId() == listOfProducts.get(i).getId()) {
					favorite.add(listOfProducts.get(i));
				}
			}
		}
		
		model.addAttribute("favorites", favorite);
		productDAO.setCategoryType(5);
        return "favorite";
    }
	
	@RequestMapping(value =  "favorite/{id}", method=RequestMethod.GET)
	public String getProductDetailsById(Model model, @PathVariable int id) {

	  favoriteId = id;
      return "redirect:http://localhost:8080/SpringShop/favorite";
  }
	
}
package com.mds.springshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mds.springshop.dao.FavoriteDAO;
import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Users;

@Controller
public class FavoritesController {
	
	private int favoriteId;
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	@Autowired
	private ProductsDAO productDAO;
	
	@Autowired
	private UsersDAO usersDAO;

	@RequestMapping(value = { "/favorite" }, method = RequestMethod.GET)
    public String getFavoritePage(Model model) {
 
		UserDetails currentUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users user;
		user = usersDAO.findUserByEmail(currentUser.getUsername());
		favoriteDAO.addFavorite(favoriteId, user.getId());
		
		productDAO.setCategoryType(5);
        return "favorite";
    }
	
	@RequestMapping(value =  "favorite/{id}", method=RequestMethod.GET)
	public String getProductDetailsById(Model model, @PathVariable int id) {

	  favoriteId = id;
      return "redirect:http://localhost:8080/SpringShop/favorite";
  }
}
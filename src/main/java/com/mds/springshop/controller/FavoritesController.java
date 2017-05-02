package com.mds.springshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mds.springshop.dao.ProductsDAO;

@Controller
public class FavoritesController {
	
	@Autowired
	private ProductsDAO productDAO;

	@RequestMapping(value = { "/favorite" }, method = RequestMethod.GET)
    public String getFavoritePage(Model model) {
 
		productDAO.setCategoryType(5);
        return "favorite";
    }
}
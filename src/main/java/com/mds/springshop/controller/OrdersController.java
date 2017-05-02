package com.mds.springshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mds.springshop.dao.ProductsDAO;

@Controller
public class OrdersController {
	
	@Autowired
	private ProductsDAO productDAO;

	 @RequestMapping(value = { "/cosCurent" }, method = RequestMethod.GET)
	 public String getCosCurentPage(Model model) {
	 
		 productDAO.setCategoryType(5);
	     return "cosCurent";
	 }
}
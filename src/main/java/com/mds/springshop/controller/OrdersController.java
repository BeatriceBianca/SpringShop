package com.mds.springshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mds.springshop.dao.ProductsDAO;

@Controller
public class OrdersController {
	
	private int orderId;
	
	@Autowired
	private ProductsDAO productDAO;

	 @RequestMapping(value = { "/cosCurent" }, method = RequestMethod.GET)
	 public String getCosCurentPage(Model model) {
	 
		 productDAO.setCategoryType(5);
	     return "cosCurent";
	 }
	 
	 @RequestMapping(value =  "detaliiComanda", method=RequestMethod.GET)
		public String getOrderDetails(Model model) {

	      return "detaliiComanda";
	  }
	 
	 @RequestMapping(value =  "detaliiComanda/{id}", method=RequestMethod.GET)
		public String getOrderDetailsById(Model model,
				@PathVariable int id) {

		  orderId = id;
	      return "redirect:http://localhost:8080/SpringShop/detaliiComanda";
	  }
}
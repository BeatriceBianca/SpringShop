package com.mds.springshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrdersController {

	 @RequestMapping(value = { "/cosCurent" }, method = RequestMethod.GET)
	    public String getCosCurentPage(Model model) {
	 
	        return "cosCurent";
	 }
}
package com.mds.springshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FavoritesController {

	@RequestMapping(value = { "/favorite" }, method = RequestMethod.GET)
    public String getFavoritePage(Model model) {
 
        return "favorite";
    }
}
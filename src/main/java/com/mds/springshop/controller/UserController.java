package com.mds.springshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Users;

@Controller
public class UserController {

	@Autowired
	UsersDAO usersDAO;
	
	@RequestMapping(value = { "/newAccount" }, method = RequestMethod.GET)
    public String getNewAccountPage(Model model) {
 
        return "newAccount";
    }
	
	@RequestMapping(value = { "/profil" }, method = RequestMethod.GET)
    public String getProfilPage(Model model) {
 
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
		Users user;
		user = usersDAO.findUserByEmail(userDetails.getUsername());
		model.addAttribute("user", user);
        return "profil";
    }
}
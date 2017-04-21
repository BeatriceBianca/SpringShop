package com.mds.springshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Users;
import com.mds.springshop.model.UsersInfo;

@Controller
public class UserController {
	@Autowired
	private UsersDAO userDAO;
	@Autowired
	UsersDAO usersDAO;
	
	@RequestMapping(value = { "/newAccount" }, method = RequestMethod.GET)
	@Transactional(propagation = Propagation.NEVER)
	public String saveUser(Model model,@ModelAttribute("registrationForm")  @Validated UsersInfo userInfo,BindingResult result,final RedirectAttributes redirectAttributes)
	{
		if (result.hasErrors()) {
            return "newAccount";
		}
		try{
			userDAO.save(userInfo);
		}
		catch(Exception e)
		{
			String message=e.getMessage();
			model.addAttribute("message", message);
			return "newAccount";
		}
		return "redirect:/login";
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
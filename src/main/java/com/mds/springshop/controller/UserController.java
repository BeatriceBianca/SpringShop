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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Users;
import com.mds.springshop.model.UsersInfo;
import com.mds.springshop.validator.RegistrationValidator;

@Controller
public class UserController {
	
	@Autowired
	private UsersDAO userDAO;
	
	@Autowired
	private ProductsDAO productDAO;
	
	@Autowired
	private RegistrationValidator registrationValidator;
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder)
	{
		Object target=dataBinder.getTarget();
		if(target==null)
			return;
		System.out.println("Target="+target);
		if(target.getClass()==UsersInfo.class)
			dataBinder.setValidator(registrationValidator);
	}
	
	@RequestMapping(value={"/newAccount"},method=RequestMethod.GET)
	public String user(Model model,@RequestParam(value="email",defaultValue="") String email)
	{
		UsersInfo userInfo=null;
		if(email!=null)
			userInfo=userDAO.findUserInfo(email);
		if(userInfo==null)
		{
			userInfo=new UsersInfo();
			userInfo.setNewUser(true);
		}
		model.addAttribute("registrationForm",userInfo);
		return "newAccount";
	}
	
	@RequestMapping(value = { "/newAccount" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String saveUser(Model model,@ModelAttribute("registrationForm")  @Validated UsersInfo userInfo,BindingResult result,final RedirectAttributes redirectAttributes)
	{
		if (result.hasErrors()) {
            return "newAccount";
		}
		if (userInfo.getLastName() == null) {
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
    productDAO.setCategoryType(5);
		return "redirect:/";
	}

	@RequestMapping(value = { "/profil" }, method = RequestMethod.GET)
    public String getProfilPage(Model model) {
 
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
		Users user;
		user = userDAO.findUserByEmail(userDetails.getUsername());
		model.addAttribute("user", user);
		
		productDAO.setCategoryType(5);
        return "profil";
    }
	
	@RequestMapping(value = { "/istoric" }, method = RequestMethod.GET)
	public String getIstoricPage(Model model) {
		return "istoric";
	}
	@RequestMapping(value = { "/editareProfil" }, method = RequestMethod.GET)
	public String getEditProfilePage(Model model){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UsersInfo userInfo=null;
			userInfo=usersDAO.findUserInfo(userDetails.getUsername());
		model.addAttribute("editForm",userInfo);
		
		Users user;
		user = usersDAO.findUserByEmail(userDetails.getUsername());
		model.addAttribute("user", user);
		
		return "editareProfil";
	}
	@RequestMapping(value = { "/editareProfil" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String postEditProfilePage(Model model,@ModelAttribute("editForm")UsersInfo userInfo,BindingResult result,final RedirectAttributes redirectAttributes)
	{
		System.out.println("USERSDAO With Email "+userInfo.getEmail());
		if (result.hasErrors()) {
            return "editareProfil";
		}
		try{
			
			userDAO.updateUser(userInfo);
		}
		catch(Exception e)
		{
			String message=e.getMessage();
			model.addAttribute("message", message);
			return "editareProfil";
		}
		return "redirect:/";
	}
}
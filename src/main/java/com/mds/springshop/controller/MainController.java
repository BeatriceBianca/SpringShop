package com.mds.springshop.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mds.springshop.dao.ProductsDAO;
 
@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class MainController {
	
	@Autowired
	private ProductsDAO productDAO;
 
    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

    }
 
    @RequestMapping("/403")
    public String accessDenied() {
        return "/403";
    }
    
    @RequestMapping({ "/index/it" })
	public String getIt() {

      productDAO.setCategoryType(6);
      return "redirect:/index";
  }
    
    @RequestMapping({ "/index/electrocasnice" })
	public String getElectocasnice() {

      productDAO.setCategoryType(7);
      return "redirect:/index";
  }
    
    @RequestMapping({ "/index/fashion" })
	public String getFashion() {

      productDAO.setCategoryType(8);
      return "redirect:/index";
  }
    
    @RequestMapping({ "/index/sport" })
	public String getSport() {

      productDAO.setCategoryType(9);
      return "redirect:/index";
  }
    
    @RequestMapping({ "/index/accesorii" })
	public String getAccesorii() {

      productDAO.setCategoryType(10);
      return "redirect:/index";
  }
 
}
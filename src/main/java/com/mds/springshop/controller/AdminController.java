package com.mds.springshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.model.PaginationResult;
import com.mds.springshop.model.ProductInfo;
 
@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class AdminController {
  
    // Configurated In ApplicationContextConfig.
    @Autowired
    private ResourceBundleMessageSource messageSource;
    
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
    
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String getLoginPage(Model model) {
 
    	return "login";
    }
	
	@RequestMapping({ "/" })
	public String firstPage() {

      return "redirect:/index";
  }
	
	@RequestMapping({ "/index" })
	public String listProductHandler(Model model,
          @RequestParam(value = "page", defaultValue = "1") int page) {

	  final int maxResult = 5;
	  final int maxNavigationPage = 10;
	 
	  PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
	                maxResult, maxNavigationPage);
      model.addAttribute("paginationProducts", result);
      return "index";
  }

}
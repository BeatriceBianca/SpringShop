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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class AdminController {
  
    // Configurated In ApplicationContextConfig.
    @Autowired
    private ResourceBundleMessageSource messageSource;
 
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

    @RequestMapping(value = { "/newAccount" }, method = RequestMethod.GET)
    public String getNewAccountPage(Model model) {
 
        return "newAccount";
    }
    
    @RequestMapping(value = { "/cosCurent" }, method = RequestMethod.GET)
    public String getCosCurentPage(Model model) {
 
        return "cosCurent";
    }
    
    @RequestMapping(value = { "/favorite" }, method = RequestMethod.GET)
    public String getFavoritePage(Model model) {
 
        return "favorite";
    }
//    @RequestMapping(value = { "/accountInfo" }, method = RequestMethod.GET)
//    public String accountInfo(Model model) {
// 
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails.getPassword());
//        System.out.println(userDetails.getUsername());
//        System.out.println(userDetails.isEnabled());
// 
//        model.addAttribute("userDetails", userDetails);
//        return "accountInfo";
//    }
}
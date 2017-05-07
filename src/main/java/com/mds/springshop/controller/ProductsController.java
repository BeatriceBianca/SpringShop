package com.mds.springshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.model.ProductInfo;
import com.mds.springshop.model.UsersInfo;

@Controller
public class ProductsController {
	
	private int productId;
	
	@Autowired
	ProductsDAO productDAO;
	
	@RequestMapping(value =  "detaliiProdus", method=RequestMethod.GET)
	public String getProductDetails(Model model) {

	  model.addAttribute("product", productDAO.getProductById(productId));
      return "detaliiProdus";
  }
	
	@RequestMapping(value =  "detaliiProdus/{id}", method=RequestMethod.GET)
	public String getProductDetailsById(Model model, @PathVariable int id) {

	  productId = id;
      return "redirect:http://localhost:8080/SpringShop/detaliiProdus";
  }
	
	@RequestMapping(value={"/editareProdus"},method=RequestMethod.GET)
	public String displayEditProduct(Model model)
	{
		ProductInfo productInfo=null;
		
		productInfo = productDAO.getProductById(productId);

		model.addAttribute("saveProductForm", productInfo);
		model.addAttribute("product", productInfo);
		return "editareProdus";
	}
	
	@RequestMapping(value = { "/editareProdus/{id}" }, method = RequestMethod.GET)
	@Transactional(propagation = Propagation.NEVER)
//	public String editProduct(@PathVariable int id, Model model,
//			@ModelAttribute("saveProductForm")  @Validated ProductInfo productInfo,BindingResult result,
//			final RedirectAttributes redirectAttributes)
	public String editProduct(@PathVariable int id, Model model)
	{
		
		productId = id;
//		model.addAttribute("saveProductForm", productInfo);
		
		return "redirect:http://localhost:8080/SpringShop/editareProdus";
	}
	
	@RequestMapping(value={"/updateProduct"},method=RequestMethod.GET)
	public String product(Model model)
	{
		ProductInfo productInfo = productDAO.getProductById(productId);
		
		model.addAttribute("saveProductForm",productInfo);
		return "updateProduct";
	}
	
	@RequestMapping(value = { "/updateProduct" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String updateProduct(Model model,
			@ModelAttribute("saveProductForm")  @Validated ProductInfo productInfo,BindingResult result,
			final RedirectAttributes redirectAttributes)
	{
		
		System.out.println("Update!!!!!!!!!!!!");
		productDAO.updateProduct(productInfo);
	    System.out.println(productInfo);
		return "redirect:/";
	}
}








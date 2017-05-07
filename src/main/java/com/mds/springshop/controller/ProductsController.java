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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.model.ProductInfo;

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
	public String updateProduct(Model model)
	{
		System.out.println("/editare//////////");
		ProductInfo productInfo=null;
		System.out.println(productId);
		productInfo = productDAO.getProductById(productId);

		model.addAttribute("saveProductForm", productInfo);
		model.addAttribute("product", productInfo);
		return "editareProdus";
	}
	
	@RequestMapping(value = { "/editareProdus/{id}" }, method = RequestMethod.GET)
	@Transactional(propagation = Propagation.NEVER)
	public String saveUser(@PathVariable int id, Model model,
			@ModelAttribute("saveProductForm")  @Validated ProductInfo productInfo,BindingResult result,
			final RedirectAttributes redirectAttributes)
	{
		System.out.println("editare/id!!!!!!!!!!!!" + id);
		productId = id;
		System.out.println(productId);
//		productDAO.updateProduct(productInfo);
		
		return "redirect:http://localhost:8080/SpringShop/editareProdus";
	}
}








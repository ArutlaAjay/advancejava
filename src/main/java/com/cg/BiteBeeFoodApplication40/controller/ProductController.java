package com.cg.BiteBeeFoodApplication40.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cg.BiteBeeFoodApplication40.entity.Product;
import com.cg.BiteBeeFoodApplication40.service.ProductServices;

@Controller
public class ProductController {
@Autowired
	ProductServices services;
	
/*-----ADD PRODUCT PAGE...*/
	@GetMapping("/addProduct")
	public String addProductPage(Model model)
	{
		model.addAttribute("product",new Product());
		return "Add_Product";
	}
	
	/*------SAVE PRODUCT-------*/
	@PostMapping("/addingProduct")
	public String addProduct(@ModelAttribute Product product)
	{
		services.addProduct(product);
		return "redirect:/admin/services";
	}
	
	
	/*-----UPDATE PRODUCT PAGE-----*/
	@GetMapping("/updateProduct/{productId}")
	public String updateProductPage(@PathVariable int productId,Model model)
	{
		Product product = services.getProduct(productId);
		model.addAttribute("product",product);
		return "Update_Product";
	}
	
	/*-----UPDATE PRODUCT BY ID-----*/
	@PostMapping("/updatingProduct/{productId}")
	public String updateProduct(
			@PathVariable int productId,
			@ModelAttribute Product product)
	{
		services.updateProduct(product, productId);
		 return "redirect:/admin/services";
	}
	
	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId)
	{
		services.deleteProduct(productId);
		 return "redirect:/admin/services";
	}
	

	
}

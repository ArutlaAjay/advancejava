package com.cg.BiteBeeFoodApplication40.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	/*.....root....*/
	@GetMapping("/")
	public String root()
	{
		return "redirect:/Login";
	}
	
	/*================Login===========================*/
	
	@GetMapping("/Login")
	public String login()
	{
		return "Login";
	}
	
	/*================Home=======================*/
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	/*================Home=======================*/
	@GetMapping("/products")
	public String products(HttpSession session)
	{
		if(session.getAttribute("loggedUser")==null)
		{
			return "redirect:/Login";
		}
		return "Products";
	}
	
	/*================ABOUT=======================*/
	@GetMapping("/about")
	public String about()
	{
		return "About";
	}
	
	/*================LOCATION=======================*/
	@GetMapping("/location")
	public String location()
	{
		return "Locate_us";
	}
	
	
	/*================LOGOUT=======================*/
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/Login";
	}
	
	/*================BUY PRODUCT(LOGIN REQUIRED)=======================*/
	@GetMapping("/buyProduct")
	public String buyProduct(@RequestParam String pname,@RequestParam double pprice,Model model,HttpSession session)
	{
		
		if(session.getAttribute("loggedUser")==null)
		{
			return "redirect:/Login";
		}
		model.addAttribute("pname", pname);
		model.addAttribute("pprice",pprice);
		
		return "BuyProduct";
	}
}

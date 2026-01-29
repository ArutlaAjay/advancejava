package com.cg.BiteBeeFoodApplication40.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cg.BiteBeeFoodApplication40.count.Logic;
import com.cg.BiteBeeFoodApplication40.entity.Orders;
import com.cg.BiteBeeFoodApplication40.entity.User;
import com.cg.BiteBeeFoodApplication40.service.OrderServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	
	@Autowired
	private OrderServices services;
	@PostMapping("/product/order")
	public String placeOrder(@ModelAttribute  Orders order,HttpSession session,Model model)
	{
		User user = (User)session.getAttribute("loggedUser");
		double totalAmount = Logic.countTotal(order.getoPrice(), order.getoQuantity());
		order.setTotalAmount(totalAmount);
		order.setOrderDate(new Date());
		order.setUser(user);
		services.saveOrder(order);
		model.addAttribute("amount",totalAmount);
		return "Order_success";
		
	}
	
	
	
}

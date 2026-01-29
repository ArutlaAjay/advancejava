package com.cg.BiteBeeFoodApplication40.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BiteBeeFoodApplication40.entity.Orders;
import com.cg.BiteBeeFoodApplication40.entity.User;
import com.cg.BiteBeeFoodApplication40.repository.OrderRepository;

@Service
public class OrderServices {
	@Autowired
OrderRepository repo;
	
	public void saveOrder(Orders order)
	{
		this.repo.save(order);
	}
	
	public void updateOrder(int id,Orders order)
	{
		order.setoId(id);
		this.repo.save(order);
	}
	public void deleteOrder(int id)
	{
		this.repo.deleteById(id);
	}
	public List<Orders>getOrders()
	{
		List<Orders>list=this.repo.findAll();
		return list;
	}
	public List<Orders>getOrdersForUser(User user)
	{
		return this.repo.findOrdersByUser(user);
	}


}

package com.cg.BiteBeeFoodApplication40.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.BiteBeeFoodApplication40.entity.Orders;
import com.cg.BiteBeeFoodApplication40.entity.User;
@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
	public List<Orders> findOrdersByUser(User user);
}

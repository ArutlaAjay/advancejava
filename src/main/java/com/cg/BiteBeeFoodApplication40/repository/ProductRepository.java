package com.cg.BiteBeeFoodApplication40.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.BiteBeeFoodApplication40.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	public Product findByPname(String name);
}

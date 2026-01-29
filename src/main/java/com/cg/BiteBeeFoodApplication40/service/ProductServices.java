package com.cg.BiteBeeFoodApplication40.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BiteBeeFoodApplication40.entity.Product;
import com.cg.BiteBeeFoodApplication40.repository.ProductRepository;

@Service
public class ProductServices {
	@Autowired
	ProductRepository repo;
	
	public void addProduct(Product p) {
		this.repo.save(p);
	}

	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) this.repo.findAll();
		return products;
	}

	public Product getProduct(int id) {
		Product product = this.repo.findById(id).get();
		return product;
	}

	public void deleteProduct(int id) {
		this.repo.deleteById(id);
	}

	public Product getProductByName(String name) {
		Product product = this.repo.findByPname(name);
		if (product != null) {
			return product;
		}
		return null;
	}

	public void updateProduct(Product p, int id) {
		p.setPid(id);
		Product prod = this.repo.findById(id).get();
        if(prod.getPid()==id)
        {
        	this.repo.save(p);
        }
	}
	
}

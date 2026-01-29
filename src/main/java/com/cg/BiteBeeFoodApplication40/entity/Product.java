
package com.cg.BiteBeeFoodApplication40.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_table")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int pid;
	private String name;
	private double pprice;
	private String pdescription;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", pprice=" + pprice + ", pdescription=" + pdescription + "]";
	}
		
	
}

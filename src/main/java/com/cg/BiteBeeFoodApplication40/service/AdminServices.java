package com.cg.BiteBeeFoodApplication40.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BiteBeeFoodApplication40.entity.Admin;
import com.cg.BiteBeeFoodApplication40.repository.AdminRepository;


@Service
public class AdminServices {

	
	@Autowired
	AdminRepository repo;
	
	/*public List<Admin> getAllAdmin()
	{
		List<Admin>list=repo.findAll();
		return list;
		
	}
	
	public void getAdmin()
	{
		repo.findBy
	}
	
	public void addAdmin()
	{
		
	}
	
	public void delete()
	{
		
	}*/
	
	
	
	public void addAdmin(com.cg.BiteBeeFoodApplication40.entity.Admin admin)
	{
		this.repo.save(admin);
	}
	public void delete(int id)
	{
		this.repo.deleteById(id);
	}
	public List<Admin>getAll()
	{
		 List<Admin> admins=(List<Admin>)this.repo.findAll();
		 return admins;
	}
	public Admin getAdmin(int id)
	{
		Admin admin=this.repo.findById(id).get();
		return admin;
	}
	public void update(Admin admin,int id)
	{
		for(Admin ad:getAll())
		{
			if(ad.getAdminId()==id)
			{
				this.repo.save(admin);
			}
		}
	}
	public boolean validateAdminCredentials(String email,String password)
	{
		Admin admin=repo.findByAdminEmail(email);
		if(admin!=null && admin.getAdminPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	
}

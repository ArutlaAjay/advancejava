package com.cg.BiteBeeFoodApplication40.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BiteBeeFoodApplication40.entity.User;
import com.cg.BiteBeeFoodApplication40.repository.UserRespository;
@Service
public class UserServices {

	@Autowired
	UserRespository repo;
	public List<User> getAllUser()
	{
		List<User>list=repo.findAll();
		return list;
		
	}
	
	
	public User getUser(int id)
	{
		
		User u = repo.findById(id).get();
		return u;
	}
	
	
	public User getUserByEmail(String email)
	{
		
	return	repo.findUserByUemail(email);
		
	}
	
	public boolean existsByEmail(String email)
	{
		return repo.existsByUemail(email);
	}
	
	public void addUser(User u)
	{
		repo.save(u);
	}
	
	public void updateUser(User user,int id)
	{
		user.setU_id(id);
		repo.save(user);	
	}
	
	public void deleteUser(int id)
	{
	//User u =repo.findById(id).get();
		//repo.delete(u);
		repo.deleteById(id);
	}
	
	// **login credientials**
	public boolean validateLoginCredentials(String email, String password) {

        if (email == null || password == null) return false;

        email = email.trim();
        password = password.trim();

        User user = repo.findUserByUemail(email);

        if (user == null) return false;

        return user.getUpassword().equals(password);
    }
}

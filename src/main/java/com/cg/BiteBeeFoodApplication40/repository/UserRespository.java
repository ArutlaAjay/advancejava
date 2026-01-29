package com.cg.BiteBeeFoodApplication40.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.BiteBeeFoodApplication40.entity.User;
@Repository
public interface UserRespository extends JpaRepository<User,Integer>{
	
	public User findUserByUemail(String email);
	  boolean existsByUemail(String uemail);

}

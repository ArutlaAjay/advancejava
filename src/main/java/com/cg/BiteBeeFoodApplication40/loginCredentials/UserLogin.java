package com.cg.BiteBeeFoodApplication40.loginCredentials;

public class UserLogin {
	private String UserEmail;
	private String UserPassword;
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserLogin [UserEmail=" + UserEmail + ", UserPassword=" + UserPassword + "]";
	}
	
	
}

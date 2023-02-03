package com.springsecurity.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	private String usersEmail;
	private String password;
	private String role;
	 
	
	public Users() {
		
	}
	
	public Users(String usersEmail, String password,String role) {
		super();
		this.usersEmail = usersEmail;
		this.password = password;
		this.role = role;
	}

	public String getUsersEmail() {
		return usersEmail;
	}

	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [usersEmail=" + usersEmail + ", password=" + password + ", role=" + role + "]";
	}

	
	
	
	
	
}

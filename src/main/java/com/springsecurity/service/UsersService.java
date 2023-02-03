package com.springsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springsecurity.entity.Users;



@Service
public interface UsersService {
	
	public String addUser(Users user);
	public List<Users> ShowAllUser(Users user);
	public String deleteUser(String usersEmail);
	public Users validateUser(Users user);
	

}

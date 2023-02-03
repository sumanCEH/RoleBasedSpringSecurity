package com.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Users;
import com.springsecurity.repository.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepo usersRepo;
	
	
	@Override
	public String addUser(Users user) {
		
		if(usersRepo.findById(user.getUsersEmail()).isPresent()) {
			
			return "You cant use this email";
		}
		else {
			usersRepo.save(user);
		return "user save ";
				
		}
	}

	@Override
	public List<Users> ShowAllUser(Users user) {
		
		return usersRepo.findAll();
	}

	@Override
	public String deleteUser(String usersEmail) {
		// TODO Auto-generated method stub
		
		usersRepo.deleteById(usersEmail);
		return  "User deleted Successfully";
	}

	@Override
	public Users validateUser(Users user) {
		return null;
	}

	



}

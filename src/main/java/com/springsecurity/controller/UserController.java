package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.Users;
import com.springsecurity.repository.UsersRepo;
import com.springsecurity.service.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private UsersService usersService;

	

	@GetMapping("/test")
	public String login() {
		return "user test";
	}

}

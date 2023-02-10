package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.repository.UsersRepo;
import com.springsecurity.service.UsersService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	

	@GetMapping("/test")
	public String login() {
		return "employee test";
	}

}

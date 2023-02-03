package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.Users;
import com.springsecurity.repository.UsersRepo;
import com.springsecurity.service.UsersService;

@RestController
@RequestMapping("/public")
public class HomeController {

	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/home")
	public String home() {
		return "Home page for all";
	}

	@PostMapping("/registerUser")
	public String addUser(@RequestBody Users users) {

		if (!usersRepo.findById(users.getUsersEmail()).isPresent()) {
			users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
			users.setRole("ROLE_USER");
			usersService.addUser(users);
			usersRepo.save(users);
			return "save User";
		}

		else {
			// Users user = usersRepo.findById(users.getUsersEmail()).get();
			return "User already exists";
		}
	}

	@GetMapping("/login")
	public String login() {
		return "user home page";
	}

}

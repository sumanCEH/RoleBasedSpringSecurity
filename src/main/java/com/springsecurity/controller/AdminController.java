package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springsecurity.entity.Users;
import com.springsecurity.repository.UsersRepo;
import com.springsecurity.service.UsersService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private UsersService usersService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/login")
	public String home() {
		return "Admin login Home page";
	}

	@PostMapping(path="/register/admin", consumes="application/json")
	public String addAdmin(@RequestBody Users users) {

		if (!usersRepo.findById(users.getUsersEmail()).isPresent()) {
			users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
			users.setRole("ROLE_ADMIN");
			usersService.addUser(users);
			usersRepo.save(users);
			return "save User";
		} else {
			return "USER already exists";
		}

	}

	@PostMapping(path="/register/employee", consumes="application/json")
	public String addUser(@RequestBody Users users) {

		if (!usersRepo.findById(users.getUsersEmail()).isPresent()) {
			users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
			users.setRole("ROLE_EMPLOYEE");
			usersService.addUser(users);
			usersRepo.save(users);
			return "save User";
		}

		else {
			// Users user = usersRepo.findById(users.getUsersEmail()).get();
			return "User already exists";
		}
	}

}

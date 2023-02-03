package com.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Users;
import com.springsecurity.repository.UsersRepo;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepo usersRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersRepo.findByEmail(username);
		if (users == null) {
			throw new UsernameNotFoundException("User Not Found");
		}else {
		return new CustomerUserDetails(users);
	}
	}
}

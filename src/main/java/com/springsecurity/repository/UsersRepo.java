package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Users;


@Repository
public interface UsersRepo extends JpaRepository<Users,String> {

	public Users findByEmail(String userEmail);
    

}

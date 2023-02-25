package com.lti.eshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.eshopping.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public abstract User findByEmail(String email);

}

package com.lti.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lti.eshopping.model.CustomUserDetails;
import com.lti.eshopping.model.User;
import com.lti.eshopping.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired 
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepo.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

}

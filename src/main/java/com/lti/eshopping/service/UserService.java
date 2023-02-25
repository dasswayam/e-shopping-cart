package com.lti.eshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lti.eshopping.model.User;
import com.lti.eshopping.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public User register(User user) {
		
		String password=new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(password);
		return userRepo.save(user);
	}

	@Override
	public List<User> users() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}

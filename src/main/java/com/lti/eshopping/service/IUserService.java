package com.lti.eshopping.service;

import java.util.List;

import com.lti.eshopping.model.User;

public interface IUserService {
	
	public abstract User register(User user);
	public abstract List<User> users();

}

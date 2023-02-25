package com.lti.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.eshopping.model.User;
import com.lti.eshopping.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<User> register(@RequestBody User user)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","user added successfully");
		ResponseEntity<User> response= new ResponseEntity<>(userService.register(user),headers,HttpStatus.CREATED);
		return response;
	}

	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ResponseEntity<List<User>> users()
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","user found successfully");
		ResponseEntity<List<User>> response= new ResponseEntity<>(userService.users(),headers,HttpStatus.CREATED);
		return response;
	}
	
	
}

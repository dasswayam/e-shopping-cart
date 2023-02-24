package com.lti.eshopping.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping("/hello")
	public String hello()
	{
		System.out.print("console suceed");
		return "hello Niraj";
	}

}

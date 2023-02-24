package com.lti.eshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.eshopping.model.Cart;
import com.lti.eshopping.service.ICartService;

@RestController
public class CartContoller {
	
	@Autowired
	ICartService cartService;
	
	@RequestMapping(value="/add-to-cart",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","product added to cart successfully");
		ResponseEntity<Cart> response= new ResponseEntity<>(cartService.addToCart(cart),headers,HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value="/update-cart",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","cart updated successfully");
		ResponseEntity<Cart> response= new ResponseEntity<>(cartService.updateCart(cart),headers,HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value="/checkout",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Cart> checkOut(@RequestBody Cart cart)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","cart empty, orders populated");
		ResponseEntity<Cart> response= new ResponseEntity<>(cartService.checkOut(cart),headers,HttpStatus.CREATED);
		return response;
	}
	

}

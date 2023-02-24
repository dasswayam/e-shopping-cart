package com.lti.eshopping.service;


import com.lti.eshopping.model.Cart;


public interface ICartService {
	
	public abstract Cart addToCart(Cart cart);
	public abstract Cart checkOut(Cart cart);
	public abstract Cart updateCart(Cart cart);
	
}

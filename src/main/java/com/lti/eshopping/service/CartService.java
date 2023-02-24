package com.lti.eshopping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.eshopping.model.Cart;
import com.lti.eshopping.model.Order;
import com.lti.eshopping.repository.CartRepository;
import com.lti.eshopping.repository.OrderRepository;


@Service
public class CartService implements ICartService {

	@Autowired
	CartRepository cartRepo;
	@Autowired
	OrderRepository orderRepo;
	
	static int order_id=0;
	
	@Override
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepo.save(cart);
	}

	@Override
	public Cart checkOut(Cart cart) {
		// TODO Auto-generated method stub
		orderRepo.save(new Order(order_id++,cart.getUser().getFirstName(),cart.getProduct().getProductName(),cart.getQuantity(),cart.getQuantity()*cart.getProduct().getPrice()));
		cartRepo.delete(cart);
		return null;
	}

	@Override
	public Cart updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepo.save(cart);
	}
	
	

}

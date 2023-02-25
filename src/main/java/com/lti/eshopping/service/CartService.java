package com.lti.eshopping.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.eshopping.model.Cart;
import com.lti.eshopping.model.Order;
import com.lti.eshopping.model.Product;
import com.lti.eshopping.repository.CartRepository;
import com.lti.eshopping.repository.OrderRepository;
import com.lti.eshopping.repository.ProductRepository;


@Service
public class CartService implements ICartService {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepo.save(cart);
	}

	@Override
	public Cart checkOut(Cart cart) {
		// TODO Auto-generated method stub
		Product product=productRepo.findById(cart.getProduct().getProductId()).get();
		if(product.getAvailableQuantity()!=0 && product.getAvailableQuantity()>=cart.getQuantityNeeded())
		{
		product.setAvailableQuantity(product.getAvailableQuantity()-cart.getQuantityNeeded());	
		orderRepo.save(new Order(cart.getUser().getFirstName(),cart.getProduct().getProductName(),cart.getQuantityNeeded(),cart.getQuantityNeeded()*cart.getProduct().getPrice()));
		cartRepo.delete(cart);
		}
		return cart;
	}

	@Override
	public Cart updateCart(Cart cart) {
		// TODO Auto-generated method stub	
		Cart cartItem=cartRepo.findByProduct_productIdAndUser_userId(cart.getProduct().getProductId(),cart.getUser().getUserId());
		cart.setCartId(cartItem.getCartId());
		return cartRepo.save(cart);
	}
	
	

}

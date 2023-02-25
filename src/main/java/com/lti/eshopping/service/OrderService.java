package com.lti.eshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.eshopping.model.Order;
import com.lti.eshopping.model.Product;
import com.lti.eshopping.repository.OrderRepository;
import com.lti.eshopping.repository.ProductRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<Order> viewOrders() {
		// TODO Auto-generated method stub	
		return orderRepo.findAll();
	}

	@Override
	public Order cancelOrder(int orderId) {
		// TODO Auto-generated method stub
		Order order=orderRepo.findById(orderId).get();
		Product product =productRepo.findByProductName(order.getProductName());
		if(product.getAvailableQuantity()==0)
		{
			product.setAvailableQuantity(order.getQuantity());
		}
		else
		{
			product.setAvailableQuantity(order.getQuantity()+product.getAvailableQuantity());
		}
		orderRepo.deleteById(orderId);
		return order;
	}

}

package com.lti.eshopping.service;

import java.util.List;

import com.lti.eshopping.model.Order;

public interface IOrderService {
	
	public abstract List<Order> viewOrders();
	public abstract Order cancelOrder(int orderId);

}

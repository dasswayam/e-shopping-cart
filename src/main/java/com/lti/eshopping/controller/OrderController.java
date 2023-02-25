package com.lti.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.eshopping.model.Order;
import com.lti.eshopping.service.IOrderService;

@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@RequestMapping(value="/view-orders",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<Order>> viewOrders()
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","orders found successfully");
		ResponseEntity<List<Order>> response= new ResponseEntity<>(orderService.viewOrders(),headers,HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value="/cancel-order/{order_id}",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Order> cancelOrder(@PathVariable(name = "order_id") int order_id)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","order cancelled successfully");
		ResponseEntity<Order> response= new ResponseEntity<>(orderService.cancelOrder(order_id),headers,HttpStatus.CREATED);
		return response;
	}
	

}

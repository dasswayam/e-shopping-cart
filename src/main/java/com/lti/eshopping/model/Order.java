package com.lti.eshopping.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {

	@Column(name="order_id")
    private int orderId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total")
	private int total;
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(int orderId, String userName, String productName, int quantity, int total) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.productName = productName;
		this.quantity = quantity;
		this.total = total;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userName=" + userName + ", productName=" + productName + ", quantity="
				+ quantity + ", total=" + total + "]";
	}
	
	
	
	
	
}

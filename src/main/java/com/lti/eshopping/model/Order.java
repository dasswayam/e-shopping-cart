package com.lti.eshopping.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GenericGenerator(name="order_seq",strategy="increment")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="order_seq")
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="in_cart")
	private boolean inCart;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, boolean inCart, Product product, User user) {
		super();
		this.orderId = orderId;
		this.inCart = inCart;
		this.product = product;
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public boolean isInCart() {
		return inCart;
	}

	public void setInCart(boolean inCart) {
		this.inCart = inCart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", inCart=" + inCart + ", product=" + product + ", user=" + user + "]";
	}
	
	
	

}

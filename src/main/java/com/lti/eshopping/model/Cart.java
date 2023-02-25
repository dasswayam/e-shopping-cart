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
@Table(name="cart")
public class Cart {
	
	@Id
	@GenericGenerator(name="cart_seq",strategy="increment")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cart_seq")
	@Column(name="cart_id")
	private int cartId;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="quantity_needed")
	private int quantityNeeded;
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int cartId, User user, Product product, int quantityNeeded) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.product = product;
		this.quantityNeeded = quantityNeeded;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQuantityNeeded() {
		return quantityNeeded;
	}


	public void setQuantityNeeded(int quantityNeeded) {
		this.quantityNeeded = quantityNeeded;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", product=" + product + ", quantityNeeded="
				+ quantityNeeded + "]";
	}
	
	
	

}

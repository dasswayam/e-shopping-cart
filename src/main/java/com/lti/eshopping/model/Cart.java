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
	@JoinColumn(name="product_name")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="user_name")
	private User user;

	@Column(name="quantity")
	private int quantity;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int cartId, Product product, User user, int quantity) {
		super();
		this.cartId = cartId;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}



	public int getCartId() {
		return cartId;
	}

	public void setOrderId(int orderId) {
		this.cartId = orderId;
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

   

	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", product=" + product + ", user=" + user + ", quantity=" + quantity + "]";
	}

	

	
	

}

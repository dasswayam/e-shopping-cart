package com.lti.eshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.eshopping.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public abstract Cart findByProduct_productIdAndUser_userId(int productId,int userId);	

}

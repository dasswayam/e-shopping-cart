package com.lti.eshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lti.eshopping.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public abstract List<Product> findByCategory_categoryName(String category_name);

}

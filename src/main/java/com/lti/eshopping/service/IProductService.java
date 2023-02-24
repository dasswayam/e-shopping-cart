package com.lti.eshopping.service;

import java.util.List;

import com.lti.eshopping.model.Product;

public interface IProductService {

	public abstract List<Product> getByCategory(String category_name);
	public abstract Product addProduct(Product product);
	public abstract Product updateProduct(Product product);
	
}

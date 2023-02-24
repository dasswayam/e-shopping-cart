package com.lti.eshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.eshopping.model.Product;
import com.lti.eshopping.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	ProductRepository productRepo;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getByCategory(String category_name) {
		return productRepo.findByCategory_categoryName(category_name);
	}
	
	
}

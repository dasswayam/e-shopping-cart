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

import com.lti.eshopping.model.Product;
import com.lti.eshopping.service.IProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	IProductService productService;
	
	@RequestMapping(value="/add-product",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","product added successfully");
		ResponseEntity<Product> response= new ResponseEntity<>(productService.addProduct(product),headers,HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value = "/get-product-by-category/{category-name}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Product>> getProductByCategoryName(@PathVariable(name = "category-name") String categoryName) 
	{
		List<Product> products = productService.getByCategory(categoryName);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Products found successfully!");
		ResponseEntity<List<Product>> response = new ResponseEntity<>(products, headers, status);
		return response;
	}
	
	@RequestMapping(value="/update-product",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","product updated successfully");
		ResponseEntity<Product> response= new ResponseEntity<>(productService.updateProduct(product),headers,HttpStatus.CREATED);
		return response;
	}

}

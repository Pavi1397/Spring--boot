package com.deloitte.deloittespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.deloitte.deloittespringboot.exception.ProductNotFoundException;
import com.deloitte.deloittespringboot.model.Product;
import com.deloitte.deloittespringboot.service.ProductService;

@RestController
public class HelloController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		
		ResponseEntity<Product> productResponse = new ResponseEntity<> (service.saveProduct(product),HttpStatus.CREATED);
		return productResponse;
		//return service.saveProduct(product);
	}
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{pid}")
	public Product getProductbyId(@PathVariable("pid")int pid){
		return service.getProduct(pid);
	}
	@DeleteMapping("/products/{pid}")
		public ResponseEntity<Product> deleteProductbyId(@PathVariable("pid")int pid){
		ResponseEntity<Product> deletedProduct;
		if(!service.checkIfExists(pid)) {
		throw new ProductNotFoundException("pid :" + pid);
	}
	else {
		deletedProduct = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		service.deleteProductById(pid);
		deletedProduct = new ResponseEntity<Product>(HttpStatus.OK);
	return deletedProduct;
}
	@GetMapping("/products/name/{pname}")
	public Product getProductByName(@PathVariable("pname")String pname){
		return service.getProductByName(pname);
	}
	@GetMapping("/products/price/range/from/{from}/to/{to}")
	public List<Product> getProductsInRange(@PathVariable("from") float from,@PathVariable ("to") float to){
		return service.getProductsInRange(from, to);
	}
	@GetMapping("/products/name/{pname}/price/{price}")
	public Product getProductByNameAndPrice(@PathVariable("pname")String pname, @PathVariable ("price") float price){
		return service.getProductByNameAndPrice(pname, price);
	}
}


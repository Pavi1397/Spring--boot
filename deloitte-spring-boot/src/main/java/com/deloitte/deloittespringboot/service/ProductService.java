package com.deloitte.deloittespringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.deloittespringboot.model.Product;
import com.deloitte.deloittespringboot.repo.ProductRepo;

import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;

	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	public List<Product> getAllProducts(){
		return repo.findAll();
		
	}
	public Product getProduct(int pid) {
		return repo.getOne(pid);
	}
	public void deleteProductById (int pid) {
		repo.deleteById(pid);
	}
	public boolean checkIfExists (int pid) {
		 return repo.existsById(pid);
	}
	public Product getProductByName(String pname) {
		return repo.findByPname(pname);
	}
	public Product getProductByNameAndPrice(String pname,float price) {
		return repo.findByPnameAndPrice(pname,price);
	}
	public List<Product>getProductsInRange(float from, float to){
		return repo.findProductsInRange(from, to);
	}
}
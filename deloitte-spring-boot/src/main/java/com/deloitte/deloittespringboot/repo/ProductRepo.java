package com.deloitte.deloittespringboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.deloittespringboot.model.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
	public Product findByPname(String pname);
	public Product findByPnameAndPrice(String pname,float price);
	
	@Query("from Product where price between :from and :to")
	public List<Product>findProductsInRange(float from, float to);
	
	
}
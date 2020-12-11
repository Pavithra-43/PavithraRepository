package com.cg.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findByProductName(String productName);
	
	
	public List<Product> findByProductBrand(String productBrand);
	
	
	public List<Product> findByProductCategory(String productCategory);
	

}

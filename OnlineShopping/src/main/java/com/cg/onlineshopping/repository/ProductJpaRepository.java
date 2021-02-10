package com.cg.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.onlineshopping.entity.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findByProductName(String productName);
	
	
	public List<Product> findByProductBrand(String productBrand);
	
	@Query("select product from Product product where product.productCategory=?1")
	public List<Product> findAllCosmetics(String productCategory);
	
	@Query("select product from Product product where product.productCategory=?1")
	public List<Product> findAllAccessories(String productCategory);
	

}

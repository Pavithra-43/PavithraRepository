package com.cg.onlineshopping.Service;

import java.util.List;

import com.cg.onlineshopping.entity.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(long productId);
	public Product getProductById(long productId);
	public List<Product> getAllProducts();
	public List<Product> getProductsByName(String productName);
	public List<Product> getProductsByBrand(String productBrand);
	public List<Product> getAllproductsByCategory(String productCategory);
}

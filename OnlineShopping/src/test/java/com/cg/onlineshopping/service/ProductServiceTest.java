package com.cg.onlineshopping.service;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.onlineshopping.entity.Product;
@SpringBootTest
class ProductServiceTest {

	@Autowired
	ProductService service;
	@Test
	void addTest() {
		Product product = new Product("television", "home appliances", "samsung", 50000.10, "LED", "In stock");
	    product =service.addProduct(product);
		assertEquals("television", product.getProductName());
	} 

//	@Test
//	void updateTest() {
//		Product product = new Product("cooler", "home appliances", "samsung", 80000.10, "Good quality", "In stock");
//		product=service.addProduct(product);
//		long id=product.getProductId();
//		Product newProduct = new Product(id, "cooler", "home appliances", "sony", 90000.80, "Good quality", "In stock");
//	    newProduct=service.updateProduct(newProduct);
//		assertEquals(90000.80, newProduct.getUnitPrice());
//
//	}

	@Test
	void deleteProduct() {
		Product product = new Product("lipstick", "cosmetics", "baby lips", 500.00, "organic and long lasting","In stock");
		product = service.addProduct(product);
		long id = product.getProductId();
		Product deleteProduct = service.deleteProduct(id);
		assertEquals("lipstick", deleteProduct.getProductName());

	}

	@Test
	void getProduct() {
		Product product = new Product("bag", "accessories", "american tourister", 700.00, "stylish", "In stock");
		product = service.addProduct(product);
		long id = product.getProductId();
		Product getProduct = service.getProductById(id);
		assertEquals(id, getProduct.getProductId());
		assertEquals("bag", getProduct.getProductName());

	}

	@Test
	void getAllProducts() {
		Product product1 = new Product("watch", "accessories", "fast track", 1200.50, "stylish and water proof","In stock");
		service.addProduct(product1);
		Product product2 = new Product("laptop", "electronics", "hp", 90000.0, "8gb ram and hd screen", "In stock");
		service.addProduct(product2);
		List<Product> products = service.getAllProducts();
		assertTrue(!products.isEmpty());
	}

	@Test
	void getProductsByName() {
		Product product1 = new Product("mobile", "electronics", "oneplus", 65200.50, "6gb ram, and good performance","In stock");
		service.addProduct(product1);
		Product product2 = new Product("mobile", "electronics", "apple", 90000.0, "4gb ram and good camera quality","In stock");
		service.addProduct(product2);
		List<Product> products = service.getProductsByName("mobile");
		assertTrue(!products.isEmpty());
	}

	@Test
	void getProductsByBrand() {
		Product product1 = new Product("headphone", "accessories", "boat", 200.50, "good quality", "In stock");
		service.addProduct(product1);
		Product product2 = new Product("wireless headphone", "accessories", "boat", 1000.0, "colors available","In stock");
		service.addProduct(product2);
		List<Product> products = service.getProductsByBrand("boat");
		assertTrue(!products.isEmpty());
	}

//	@Test
//	void getProductsByCategory() {
//		Product product1 = new Product("mixer", "home appliances", "preethi", 3100.50, "good quality", "In stock");
//		service.addProduct(product1);
//		Product product2 = new Product("fridge", "home appliances", "lg", 75000.30, "emi available", "In stock");
//		service.addProduct(product2);
//		List<Product> products = service.getAllproductsByCategory("home appliances");
//		assertTrue(!products.isEmpty());
//	}

}

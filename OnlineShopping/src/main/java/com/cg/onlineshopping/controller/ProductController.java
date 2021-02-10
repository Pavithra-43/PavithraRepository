package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productId)
	{
		Product product=productService.getProductById(productId);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product addProduct=productService.addProduct(product);
		return new ResponseEntity<>(addProduct,HttpStatus.OK);
	}
	
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable long productId,@RequestBody Product product)
	{
		Product newProduct=productService.updateProduct(productId,product);
		return new ResponseEntity<>(newProduct,HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		List<Product> allProducts=productService.getAllProducts();
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long productId)
	{
		Product deleteProduct=productService.deleteProduct(productId);
		return new ResponseEntity<>(deleteProduct,HttpStatus.OK);
	}
	
	@GetMapping(path="/products/name/{productName}")
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable String productName)
	{
		List<Product> allProducts=productService.getProductsByName(productName);
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping(path="/products/brand/{productBrand}")
	public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String productBrand)
	{
		List<Product> allProducts=productService.getProductsByBrand(productBrand);
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping(path="/products/category/cosmetics")
	public ResponseEntity<List<Product>> getAllCosmetics()
	{
		List<Product> allProducts=productService.getAllCosmetics("cosmetics");
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	@GetMapping(path="/products/category/accessories")
	public ResponseEntity<List<Product>> getAllAccessories()
	{
		List<Product> allProducts=productService.getAllCosmetics("accessories");
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	

}

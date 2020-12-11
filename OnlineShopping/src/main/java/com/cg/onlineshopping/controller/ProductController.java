package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineshopping.Service.ProductService;
import com.cg.onlineshopping.entity.Product;
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productId)
	{
		Product product=productService.getProductById(productId);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product addProduct=productService.addProduct(product);
		return new ResponseEntity<Product>(addProduct,HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		Product newProduct=productService.updateProduct(product);
		return new ResponseEntity<Product>(newProduct,HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		List<Product> allProducts=productService.getAllProducts();
		return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long productId)
	{
		Product deleteProduct=productService.deleteProduct(productId);
		return new ResponseEntity<Product>(deleteProduct,HttpStatus.OK);
	}
	
	@GetMapping(path="/name/{productName}")
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable String productName)
	{
		List<Product> allProducts=productService.getProductsByName(productName);
		return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping(path="/brand/{productBrand}")
	public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String productBrand)
	{
		List<Product> allProducts=productService.getProductsByBrand(productBrand);
		return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping(path="/category/{productCategory}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String productCategory)
	{
		List<Product> allProducts=productService.getAllproductsByCategory(productCategory);
		return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
	}

}

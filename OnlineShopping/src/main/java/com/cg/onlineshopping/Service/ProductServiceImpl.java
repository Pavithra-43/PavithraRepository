package com.cg.onlineshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.exception.OSException;
import com.cg.onlineshopping.exception.ProductIdNotFoundException;
import com.cg.onlineshopping.repository.ProductJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductJpaRepository productRepository;
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product updateProduct=productRepository.findById(product.getProductId()).orElse(null);
		if(updateProduct!=null)
		{
			return productRepository.save(product);
		}
		else {
			throw new ProductIdNotFoundException(UtilityClass.PRODUCT_NOT_FOUND+" : "+product.getProductId());
		}
	}

	@Override
	public Product deleteProduct(long productId) {
		Product deleteProduct=productRepository.findById(productId).orElse(null);
		if(deleteProduct!=null)
		{
			productRepository.delete(deleteProduct);
			return deleteProduct;
		}
		else {
			throw new ProductIdNotFoundException(UtilityClass.PRODUCT_NOT_FOUND+" : "+productId);
		}
	}

	@Override
	public Product getProductById(long productId) {
		Product product=productRepository.findById(productId).orElse(null);
		if(product!=null)
		{
			return product;
		}
		else {
			throw new ProductIdNotFoundException(UtilityClass.PRODUCT_NOT_FOUND+" : "+productId);
		}
	}

	@Override
	public List<Product> getAllProducts
	() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		List<Product> allProducts= productRepository.findByProductName(productName);
		if(allProducts.isEmpty())
		{
			throw new OSException(UtilityClass.NO_RESULT+" : "+productName);
		}
		return allProducts;
	}

	@Override
	public List<Product> getProductsByBrand(String productBrand) {
		List<Product> allProducts= productRepository.findByProductBrand(productBrand);
		if(allProducts.isEmpty())
		{
			throw new OSException(UtilityClass.NO_RESULT+" : "+productBrand);
		}
		return allProducts;
	}

	@Override
	public List<Product> getAllproductsByCategory(String productCategory) {
		List<Product> allProducts= productRepository.findByProductCategory(productCategory);
		if(allProducts.isEmpty())
		{
			throw new OSException(UtilityClass.NO_RESULT+" : "+productCategory);
		}
		return allProducts;
	}

}

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

import com.cg.onlineshopping.entity.WishList;
import com.cg.onlineshopping.service.WishListService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
	@Autowired
	private WishListService wishListService;
	
	@GetMapping("/{id}")
	public ResponseEntity<WishList> getProductByWishlistId(@PathVariable("id") long wishlistId)
	{
		WishList wproduct=wishListService.getWishListById(wishlistId);
		return new ResponseEntity<>(wproduct,HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<WishList>> getAllWishlist()
	{
		List<WishList> allProducts=wishListService.getAllWishlist();
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<WishList> addWishlist(@RequestBody WishList wishList)
	{
		WishList wishlist=wishListService.addWishList(wishList);
		
		return new ResponseEntity<>(wishlist,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<WishList> deleteWishlist(@PathVariable("id") long wishlistId)
	{
		WishList wishlist=wishListService.deleteWishList(wishlistId);
		return new ResponseEntity<>(wishlist,HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<WishList> updateWishList(@RequestBody WishList wishList)
	{
		WishList wish=wishListService.updateWishList(wishList);
		return new ResponseEntity<>(wish,HttpStatus.OK);
	}
	
	
}

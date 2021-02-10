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

import com.cg.onlineshopping.entity.CartLine;
import com.cg.onlineshopping.service.CartLineService;



@RestController
@RequestMapping("/cart")
public class CartLineController {
	@Autowired
	private CartLineService cartLineService;
	
	@GetMapping("")
	public ResponseEntity<List<CartLine>> getAllCartLine()
	{
		List<CartLine> allCart=cartLineService.getAllCartLine();
		return new ResponseEntity<>(allCart, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CartLine> getCartById (@PathVariable("id") long CartId)
	{
		CartLine cartLine=cartLineService.getCartById(CartId);
		return new ResponseEntity<>(cartLine,HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<CartLine> updateCartLine(@RequestBody CartLine cartLine)
	{
		CartLine cart=cartLineService.updateCartLine(cartLine);
		return new ResponseEntity<>(cart,HttpStatus.OK);
		
	}
	
	
	@PostMapping("")
	public ResponseEntity<CartLine> createCart(@RequestBody CartLine cartLine)
	{
		CartLine cart=cartLineService.createNewCart(cartLine);
		return new ResponseEntity<>(cart,HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCartLine(@PathVariable long cartId)
	{
		String result=cartLineService.deleteCartLine(cartId);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
			
}
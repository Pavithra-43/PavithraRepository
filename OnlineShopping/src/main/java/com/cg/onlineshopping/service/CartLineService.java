package com.cg.onlineshopping.service;
import java.util.List;

import com.cg.onlineshopping.entity.CartLine;

public interface CartLineService {
	
	public List<CartLine> getAllCartLine();

	public CartLine createNewCart(CartLine cartLine);
	
	public CartLine updateCartLine(CartLine cartLine);
	
	public CartLine getCartById(long cartId);
	
	public String deleteCartLine(long cartId);
	

}

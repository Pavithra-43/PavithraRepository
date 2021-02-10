package com.cg.onlineshopping.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineshopping.entity.CartLine;
import com.cg.onlineshopping.exception.OSException;
import com.cg.onlineshopping.repository.CartLineJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;
@Service
	public class CartLineServiceImpl implements CartLineService {
	
	@Autowired
	private CartLineJpaRepository cartRepository;
	
		@Override
		public CartLine createNewCart(CartLine cartLine) {
			return cartRepository.save(cartLine);
		}

			
		@Override
		public CartLine getCartById(long cartId) {
			CartLine cart=cartRepository.findById(cartId).orElse(null);
			if(cart!=null) {
				return cart;
			}
			else {
				throw new OSException(UtilityClass.INVALID_DATA+" : "+cartId);
			}
		}


		@Override
		public List<CartLine> getAllCartLine() {
			return cartRepository.findAll();
		}


		@Override
		public String deleteCartLine(long cartId) {
			CartLine cart=cartRepository.findById(cartId).orElse(null);
			if(cart!=null) {
				cartRepository.delete(cart);
				return cartId+" deleted";
			}
			else {
				throw new OSException(UtilityClass.INVALID_DATA+ " : " +cartId);
			}
		}

		@Override
		public CartLine updateCartLine(CartLine cartLine) {
			CartLine cart=cartRepository.findById(cartLine.getCartId()).orElse(null);
			if(cart!=null)
			{
				return cartRepository.save(cartLine);
			}
			else {
				throw new OSException(UtilityClass.INVALID_DATA+ " : "+cartLine.getCartId());
			}
		}

	}


package com.cg.onlineshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.WishList;
import com.cg.onlineshopping.exception.OSException;
import com.cg.onlineshopping.repository.WishlistJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;

@Service
public class WishlistServiceImpl implements WishListService{
	@Autowired
	private WishlistJpaRepository wishlistRepository;
	
	@Override
	public WishList addWishList(WishList wishList) { 
		return wishlistRepository.save(wishList);
	}

	@Override
	public WishList deleteWishList(long wishlistId) {
		WishList deleteWishList=wishlistRepository.findById(wishlistId).orElse(null);
		if(deleteWishList!=null) {
			wishlistRepository.delete(deleteWishList);
			return deleteWishList;
		}
		else
		{
			throw new OSException(UtilityClass.INVALID_DATA+" : "+wishlistId);
		}
			
	}

	@Override
	public List<WishList> getAllWishlist() {
		return wishlistRepository.findAll();
	}

	@Override
	public WishList getWishListById(long wishlistId) {
		WishList wish=wishlistRepository.findById(wishlistId).orElse(null);
		if(wish!=null)
		{
			return wish;
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA+" : "+wishlistId);
		}
	}

	@Override
	public WishList updateWishList(WishList wishList) {
		
		WishList wish=wishlistRepository.findById(wishList.getWishListId()).orElse(null);
		if(wish!=null)
		{
			return wishlistRepository.save(wishList);
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA+" : "+wishList.getWishListId());
		}
		
	}
}


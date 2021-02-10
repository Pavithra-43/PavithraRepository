package com.cg.onlineshopping.service;

import java.util.*;
import com.cg.onlineshopping.entity.WishList;

public interface WishListService {
	public WishList addWishList(WishList wishList);
	public WishList deleteWishList(long wishlistId);
	public WishList getWishListById(long wishlistId);
	public List<WishList> getAllWishlist();
	public WishList updateWishList(WishList wishList);
}

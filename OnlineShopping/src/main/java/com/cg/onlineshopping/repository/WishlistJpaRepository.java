package com.cg.onlineshopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineshopping.entity.WishList;

public interface WishlistJpaRepository extends JpaRepository<WishList, Long> {

	
}

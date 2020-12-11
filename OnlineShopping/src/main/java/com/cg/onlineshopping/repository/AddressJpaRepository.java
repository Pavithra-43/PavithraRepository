package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineshopping.entity.Address;

public interface AddressJpaRepository extends JpaRepository<Address,Long> {
	
	
}

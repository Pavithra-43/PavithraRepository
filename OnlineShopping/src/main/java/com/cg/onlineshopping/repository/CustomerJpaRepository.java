package com.cg.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.Customer;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
	
	public List<Customer> findByCustomerName(String customerName);
	public Customer findByEmail(String email);
	public Customer findByMobile(String mobile);
	public Customer findByUsername(String username);
	

}

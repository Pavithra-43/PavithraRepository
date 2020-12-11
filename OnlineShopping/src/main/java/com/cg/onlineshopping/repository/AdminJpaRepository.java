package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.Admin;

public interface AdminJpaRepository extends JpaRepository<Admin, Long>{
	
	public Admin findByRole(String role);

}

package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineshopping.entity.AdminTable;

public interface AdminJpaRepository extends JpaRepository<AdminTable, Long>{
	
	public AdminTable findByUsername(String username);

}

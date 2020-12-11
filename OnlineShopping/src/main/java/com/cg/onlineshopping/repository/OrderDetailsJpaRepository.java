package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.OrderDetails;

public interface OrderDetailsJpaRepository extends JpaRepository<OrderDetails, Long>{

}

package com.cg.onlineshopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineshopping.entity.Payment;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {


	
}

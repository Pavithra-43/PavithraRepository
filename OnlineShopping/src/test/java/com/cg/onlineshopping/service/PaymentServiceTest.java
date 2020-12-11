package com.cg.onlineshopping.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.Service.PaymentService;
import com.cg.onlineshopping.entity.Payment;

@SpringBootTest
class PaymentServiceTest {

	@Autowired
	PaymentService service;
	
	@Test
	void makePaymentTest() 
	{
		Payment payment=new Payment();
		payment.setPaymentStatus("Pending");
		payment.setPaymentType("Cod");
		Payment newPayment=service.makePayment(payment);
		assertEquals("Pending",newPayment.getPaymentStatus());
	}
	
	@Test
	void viewAllPaymentTest()
	{
		Payment payment1=new Payment();
		payment1.setPaymentStatus("Pending");
		payment1.setPaymentType("Cod");
		Payment payment2=new Payment();
		payment2.setPaymentStatus("Received");
		payment2.setPaymentType("Credit card");
		List<Payment> payment=service.viewAllPayment();
		assertTrue(!payment.isEmpty());
	}
	
	@Test
	void updatePaymentTest()
	{
		Payment payment=new Payment();
		payment.setPaymentStatus("Pending");
		payment.setPaymentType("cod");
		Payment payment1=service.makePayment(payment);
		long id=payment1.getPaymentId();
		Payment newPayment=new Payment(id,"Recceived","Cash On Delivery",null);
		newPayment=service.updatePaymentStatus(newPayment);
		assertEquals("Received",newPayment.getPaymentStatus());
	}
	
	@Test
	void viewPaymentTest()
	{
		Payment payment=new Payment();
		payment.setPaymentStatus("Pending");
		payment.setPaymentType("Cod");
		long id=payment.getPaymentId();
		Payment viewPayment=service.viewPaymentById(id);
		assertEquals(id, viewPayment.getPaymentId());
	}
	
}

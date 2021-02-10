package com.cg.onlineshopping.service;

import com.cg.onlineshopping.entity.Payment;
import java.util.List;

public interface PaymentService {
	
	public Payment makePayment(Payment payment);
	public Payment updatePaymentStatus(Payment payment);
	public Payment viewPaymentById(long paymentId);
	public List<Payment> viewAllPayment();
	public String cancelPayment(long paymentId);
}

package com.cg.onlineshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.Payment;
import com.cg.onlineshopping.exception.OSException;
import com.cg.onlineshopping.repository.PaymentJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentJpaRepository paymentRepository;
	
	@Override
	public Payment makePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment updatePaymentStatus(Payment payment) {
		Payment updatePayment=paymentRepository.findById(payment.getPaymentId()).orElse(null);
		if(updatePayment!=null)
		{
			return paymentRepository.save(payment);
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA+" : "+payment.getPaymentId());
		}
	}

	@Override
	public Payment viewPaymentById(long paymentId) {
	     Payment viewPayment=paymentRepository.findById(paymentId).orElse(null);
		if(viewPayment!=null)
		{
			return viewPayment;
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA+" : "+paymentId);
		}
	}

	@Override
	public List<Payment> viewAllPayment() {
		List<Payment> viewAllPayment=paymentRepository.findAll();
		return viewAllPayment;
	}

	@Override
	public String cancelPayment(long paymentId) {
		Payment payment=paymentRepository.findById(paymentId).orElse(null);
		if(payment!=null)
		{
			paymentRepository.delete(payment);
			return "Payment Id "+paymentId+"---> Transaction Canceled ";
			
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA);
		}
	}
	

}

package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entity.Payment;
import com.cg.onlineshopping.service.PaymentService;
@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("")
	public ResponseEntity<Payment> addPaymentDetails(@RequestBody Payment payment)
	{
		Payment makePayment=paymentService.makePayment(payment);
		return new ResponseEntity<>(makePayment,HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<Payment> updatePaymentStatus(@RequestBody Payment payment)
	{
		Payment newPayment=paymentService.updatePaymentStatus(payment);
		return new ResponseEntity<>(newPayment,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Payment> viewPaymentById(@PathVariable("id") long paymentId)
	{
		Payment viewPayment=paymentService.viewPaymentById(paymentId);
		return new ResponseEntity<>(viewPayment,HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Payment>> viewAllPayment() {
		List<Payment> allPayment=paymentService.viewAllPayment();
		return new ResponseEntity<>(allPayment,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> cancelPayment(@PathVariable("id") long paymentId)
	{
		String result=paymentService.cancelPayment(paymentId);
		return new ResponseEntity<>(result,HttpStatus.OK);
		}
}

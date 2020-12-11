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

import com.cg.onlineshopping.Service.OrderDetailsService;
import com.cg.onlineshopping.entity.OrderDetails;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {

		@Autowired
		private OrderDetailsService orderService;
		
		@PostMapping("")
		public ResponseEntity<OrderDetails> makeOrder(@RequestBody OrderDetails order)
		{
			OrderDetails makeOrder=orderService.makeOrder(order);
			return new ResponseEntity<OrderDetails>(makeOrder,HttpStatus.OK);
		}
		
		@PutMapping("")
		public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order){
			
			OrderDetails updateOrder=orderService.updateOrder(order);
			return new ResponseEntity<OrderDetails>(updateOrder,HttpStatus.OK);
		}
		
		@GetMapping("")
		public ResponseEntity<List<OrderDetails>> viewAllOrder()
		{
			List<OrderDetails> allOrders=orderService.viewAllOrder();
			return new ResponseEntity<List<OrderDetails>>(allOrders,HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<OrderDetails> viewOrderById(@PathVariable("id") long orderId)
		{
			OrderDetails viewOrder=orderService.viewOrderById(orderId);
			return new ResponseEntity<OrderDetails>(viewOrder,HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<OrderDetails> cancelOrder(@PathVariable("id") long orderId)
		{
			OrderDetails cancelOrder=orderService.cancelOrder(orderId);
			return new ResponseEntity<OrderDetails>(cancelOrder,HttpStatus.OK);
		}
}

package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.OrderDetails;
import com.cg.onlineshopping.exception.OSException;
import com.cg.onlineshopping.repository.OrderDetailsJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	private OrderDetailsJpaRepository orderRepository;
	
	@Override
	public OrderDetails makeOrder(OrderDetails order) {
		OrderDetails makeOrder=orderRepository.save(order);
		return makeOrder;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		OrderDetails updateOrder=orderRepository.findById(order.getOrderId()).orElse(null);
		if(updateOrder!=null)
		{
			return orderRepository.save(order);
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA +" : "+order.getOrderId());
		}
	}

	@Override
	public List<OrderDetails> viewAllOrder() {
		List<OrderDetails> viewOrder=orderRepository.findAll();
		return viewOrder;
	}
	
	@Override
	public OrderDetails viewOrderById(long orderId) {
	    OrderDetails order=orderRepository.findById(orderId).orElse(null);
		if(order!=null)
		{
			return order;
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA +" : "+orderId);
		}
	}

	@Override
	public OrderDetails cancelOrder(long orderId) {
		OrderDetails cancelOrder=orderRepository.findById(orderId).orElse(null);
		if(cancelOrder!=null) {
			orderRepository.delete(cancelOrder);
			return cancelOrder;
		}
		else
			throw new OSException(UtilityClass.INVALID_DATA +" : "+orderId);
	}
	

}

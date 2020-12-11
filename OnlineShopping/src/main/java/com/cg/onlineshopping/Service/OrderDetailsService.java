package com.cg.onlineshopping.Service;

import com.cg.onlineshopping.entity.OrderDetails;
import java.util.List;

public interface OrderDetailsService {

	public OrderDetails makeOrder(OrderDetails order);
	public OrderDetails updateOrder(OrderDetails order);
	public List<OrderDetails> viewAllOrder();
	public OrderDetails viewOrderById(long orderId);
	public OrderDetails cancelOrder(long orderId);
	
}

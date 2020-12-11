package com.cg.onlineshopping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.Service.OrderDetailsService;
import com.cg.onlineshopping.entity.OrderDetails;

@SpringBootTest
public class OrderDetailsServiceTest {

	@Autowired
	private OrderDetailsService service;

	OrderDetails order;

	@BeforeEach
	void setUp() throws Exception {
		order = new OrderDetails();
	}

	@AfterEach
	void tearDown() throws Exception {
		order = null;
	}

	@Test
	public void testAdd() {
		order.setOrderDate("9th nov");
		order.setTotalAmount(500.00);
		order.setExpectedDeliveryDate("13th nov");
		order.setOrderStatus("In progress");
		order = service.makeOrder(order);
		assertEquals("9th nov", order.getOrderDate());

	}

	@Test
	void testGetAllOrders() {
		order.setOrderDate("6th nov");
		order.setTotalAmount(10000.00);
		order.setExpectedDeliveryDate("10th nov");
		order.setOrderStatus("Delivered");
		order = service.makeOrder(order);
		List<OrderDetails> orders = service.viewAllOrder();
		assertTrue(!orders.isEmpty());

	}

	@Test
	public void testViewOrder() throws AccountNotFoundException {
		order.setOrderDate("15th nov");
		order.setTotalAmount(700.00);
		order.setExpectedDeliveryDate("18th nov");
		order.setOrderStatus("shipped");
		order = service.makeOrder(order);
		Long id = order.getOrderId();
		order = service.viewOrderById(id);
		assertEquals("15th nov", order.getOrderDate());

	}

	@Test
	public void testUpdateOrder() throws AccountNotFoundException {
		order.setOrderDate("19th nov");
		order.setTotalAmount(700.00);
		order.setExpectedDeliveryDate("20th nov");
		order.setOrderStatus("shipped");
		order = service.makeOrder(order);
		Long id = order.getOrderId();
		order = new OrderDetails(id, 700.00, "15th nov", "25th nov", "delayed", null);
		order = service.updateOrder(order);
		assertEquals("25th nov", order.getExpectedDeliveryDate());

	}

}

package com.cg.onlineshopping.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.Service.CustomerService;
import com.cg.onlineshopping.entity.Address;
import com.cg.onlineshopping.entity.Customer;

@SpringBootTest
class CustomerServiceTest {
	@Autowired
	CustomerService service;

	@Test
	void registerCustomer() {
		Customer cust=new Customer();
		cust.setCustomerName("saisri");
		cust.setEmail("sai@gmail.com");
		cust.setGender("female");
		cust.setMobile("7829631470");
		cust.setPassword("sai@456");
		cust.setUsername("sai@56");
		
		cust=service.registerCustomer(cust);
		assertEquals("sai@56", cust.getUsername());
	}
	
	@Test
	void updateCustomer() {
		Customer cust=new Customer();
		cust.setCustomerName("pavi");
		cust.setEmail("pavi@gmail.com");
		cust.setGender("female");
		cust.setMobile("8778749596");
		cust.setPassword("pavii@4");
		cust.setUsername("pavi@56");
		Address address=new Address();
		address.setAddressLine1("12/15");
		address.setAddressLine2("main street");
		address.setAddressType("home");
		address.setCity("Chennai");
		address.setCountry("india");
		address.setState("TN");
		cust.setAddress(address);
		cust=service.registerCustomer(cust);
		long id=cust.getCustomerId();
		cust=new Customer(id, "pavithra muthusamy", "pavirat@43", "pavithra muthusamy", "female", "8778749596", "pavi@gmail.com",address , null, null);
		cust=service.updateCustomer(cust);
		assertEquals("pavithra muthusamy", cust.getCustomerName());
	}
	
	@Test
	void deleteCustomer() {
		Customer cust=new Customer();
		cust.setCustomerName("deepan");
		cust.setEmail("deepzz@gmail.com");
		cust.setGender("male");
		cust.setMobile("7829678470");
		cust.setPassword("deepan@456");
		cust.setUsername("deepan@56");
		cust=service.registerCustomer(cust);
		long id=cust.getCustomerId();
		cust=service.removeAccount(id);
		assertEquals("deepan", cust.getCustomerName());
	}
	
	@Test
	void getCustomer() {
		Customer cust=new Customer();
		cust.setCustomerName("ragul");
		cust.setEmail("depragul@gmail.com");
		cust.setGender("male");
		cust.setMobile("7845678470");
		cust.setPassword("deepan@456");
		cust.setUsername("deepanragul@56");
		cust=service.registerCustomer(cust);
		long id=cust.getCustomerId();
		cust=service.getCustomerById(id);
		assertEquals("ragul", cust.getCustomerName());
	}
	
	@Test
	void getAllCustomer()
	{
		Customer cust=new Customer();
		cust.setCustomerName("naveen");
		cust.setEmail("naveen@gmail.com");
		cust.setGender("male");
		cust.setMobile("7987678470");
		cust.setPassword("naveen@456");
		cust.setUsername("naveenragul@56");
		cust=service.registerCustomer(cust);
		List<Customer> allCustomer=service.getAllCustomers();
		assertTrue(!allCustomer.isEmpty());
	}

}

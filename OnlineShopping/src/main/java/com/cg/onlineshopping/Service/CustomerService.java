package com.cg.onlineshopping.Service;

import java.util.List;

import com.cg.onlineshopping.entity.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeAccount(Long customerId);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(long customerId);
	public List<Customer> getCustomersByName(String customerName);
	public Customer getCustomerByEmail(String email);
	public Customer getCustomerByMobile(String mobile);
	public Customer getCustomerByUsername(String username);
	public boolean validateCustomer(String username,String password);
	

}

package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineshopping.entity.Customer;
import com.cg.onlineshopping.exception.InvalidUserException;
import com.cg.onlineshopping.exception.OSException;
import com.cg.onlineshopping.repository.CustomerJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerJpaRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}

	@Override
	public Customer removeAccount(Long customerId) {
		Customer cust=customerRepository.findById(customerId).orElse(null);
		if(cust!=null) {
			customerRepository.delete(cust);
			return cust;
		}
		else {
			throw new InvalidUserException(UtilityClass.CUSTOMER_NOT_FOUND+" : " +customerId);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long customerId) {
		Customer cust=customerRepository.findById(customerId).orElse(null);
		if(cust!=null)
		{
			return cust;
		}
		else {
			throw new InvalidUserException(UtilityClass.CUSTOMER_NOT_FOUND+" : " +customerId);
		}
	}

	@Override
	public List<Customer> getCustomersByName(String customerName) {
		List<Customer> allCustomer=customerRepository.findByCustomerName(customerName);
		if(allCustomer.isEmpty())
		{
			throw new OSException(UtilityClass.NO_RESULT+ " : "+customerName);
		}
		return allCustomer;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer customer=customerRepository.findByEmail(email);
		if(customer==null)
		{
			throw new OSException(UtilityClass.NO_RESULT+ " : "+email);
		}
		return customer;
	}

	@Override
	public Customer getCustomerByMobile(String mobile) {
		Customer customer=customerRepository.findByMobile(mobile);
		if(customer==null)
		{
			throw new OSException(UtilityClass.NO_RESULT+ " : "+mobile);
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust=customerRepository.findById(customer.getCustomerId()).orElse(null);
		if(cust!=null) {
			return customerRepository.save(customer);
		}
		else {
			throw new InvalidUserException(UtilityClass.CUSTOMER_NOT_FOUND+" : " +customer.getCustomerId());
		}
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Customer customer=customerRepository.findByUsername(username);
		if(customer==null)
		{
			throw new InvalidUserException(UtilityClass.CUSTOMER_NOT_FOUND);
		}
		return customer;
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		Customer customer=customerRepository.findByUsername(username);
		if(customer.getPassword().equals(password))
		{
			return customer;
		}
		else {
			throw new InvalidUserException(UtilityClass.INVALID_DATA);
		}
	}

	

}

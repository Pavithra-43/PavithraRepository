package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.Service.CustomerService;
import com.cg.onlineshopping.entity.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId)
	{
		Customer cust=customerService.getCustomerById(customerId);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer)
	{
		Customer cust=customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		Customer newCust=customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(newCust,HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> allCustomers=customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomerAccount(@PathVariable("id") long customerId)
	{
		Customer deleteCust=customerService.removeAccount(customerId);
		return new ResponseEntity<Customer>(deleteCust,HttpStatus.OK);
	}
	
	@GetMapping(path="/name/{customerName}")
	public ResponseEntity<List<Customer>> getCustomersByName(@PathVariable String customerName)
	{
		List<Customer> allCustomers=customerService.getCustomersByName(customerName);
		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
	}
	
	@GetMapping(path="/email/{byEmail}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("byEmail") String email)
	{
		Customer cust=customerService.getCustomerByEmail(email);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@GetMapping(path="/mobile/{byMobile}")
	public ResponseEntity<Customer> getCustomerByMobile(@PathVariable("byMobile") String mobile)
	{
		Customer cust=customerService.getCustomerByMobile(mobile);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@GetMapping(path="/username/{un}")
	public ResponseEntity<Customer> getCustomerUsername(@PathVariable("un") String username)
	{
		Customer cust=customerService.getCustomerByUsername(username);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@GetMapping(path="/signin/{un}/pass/{password}")
	public ResponseEntity<String> validateCustomer(@PathVariable("un") String username,@PathVariable("password") String password)
	{
		boolean validCustomer=customerService.validateCustomer(username, password);
		if(validCustomer)
		{
			return new ResponseEntity<String>("Welcome back!!!",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Sign Up to Explore more :)",HttpStatus.OK);
		}
	}

}

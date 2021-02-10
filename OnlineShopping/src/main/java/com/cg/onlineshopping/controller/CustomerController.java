package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entity.Customer;
import com.cg.onlineshopping.service.CustomerService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId)
	{
		Customer cust=customerService.getCustomerById(customerId);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer)
	{
		Customer cust=customerService.registerCustomer(customer);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		Customer newCust=customerService.updateCustomer(customer);
		return new ResponseEntity<>(newCust,HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> allCustomers=customerService.getAllCustomers();
		return new ResponseEntity<>(allCustomers,HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomerAccount(@PathVariable("id") long customerId)
	{
		Customer deleteCust=customerService.removeAccount(customerId);
		return new ResponseEntity<>(deleteCust,HttpStatus.OK);
	}
	
	@GetMapping(path="/customer/name/{customerName}")
	public ResponseEntity<List<Customer>> getCustomersByName(@PathVariable String customerName)
	{
		List<Customer> allCustomers=customerService.getCustomersByName(customerName);
		return new ResponseEntity<>(allCustomers,HttpStatus.OK);
	}
	
	@GetMapping(path="/customer/email/{byEmail}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("byEmail") String email)
	{
		Customer cust=customerService.getCustomerByEmail(email);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@GetMapping(path="/customer/mobile/{byMobile}")
	public ResponseEntity<Customer> getCustomerByMobile(@PathVariable("byMobile") String mobile)
	{
		Customer cust=customerService.getCustomerByMobile(mobile);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@GetMapping(path="/customer/username/{un}")
	public ResponseEntity<Customer> getCustomerUsername(@PathVariable("un") String username)
	{
		Customer cust=customerService.getCustomerByUsername(username);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@GetMapping(path="/customer/signin/{username}/{password}")
	public ResponseEntity<Customer> validateCustomer(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		Customer validCustomer=customerService.validateCustomer(username, password);
		return new ResponseEntity<>(validCustomer,HttpStatus.OK);
		
	}

}

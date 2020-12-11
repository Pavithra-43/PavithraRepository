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
import com.cg.onlineshopping.Service.AddressService;
import com.cg.onlineshopping.entity.Address;


@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping("")
	public ResponseEntity<List<Address>> getAllAddress()
	{
		List<Address> allAddress=addressService.getAllAddress();
		return new ResponseEntity<List<Address>>(allAddress,HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Address> getAddressById (@PathVariable("id") long addressId)
	{
		Address address=addressService.getAddressById(addressId);
		return new ResponseEntity<Address>(address,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Address> addAddress(@RequestBody Address address)
	{
		Address addAddress=addressService.addAddress(address);
		return new ResponseEntity<Address>(addAddress, HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address){
		
		Address updateAddress=addressService.updateAddress(address);
		return new ResponseEntity<Address>(updateAddress,HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable("id") long addressId){
		Address deleteAddress=addressService.deleteAddress(addressId);
		return new ResponseEntity<Address>(deleteAddress,HttpStatus.OK);
	}
}

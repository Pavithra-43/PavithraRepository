package com.cg.onlineshopping.Service;

import com.cg.onlineshopping.entity.Address;

import java.util.List;
public interface AddressService {
	
	public List<Address> getAllAddress();
	public Address addAddress(Address address);
	public Address updateAddress(Address address);
	public Address deleteAddress(long addressId);
	public Address getAddressById(long addressId);
	
}

package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.Address;
import com.cg.onlineshopping.exception.OSException;
import com.cg.onlineshopping.repository.AddressJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressJpaRepository addressRepository;
	
	@Override
	public Address addAddress(Address address) { 
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		Address updateAddress=addressRepository.findById(address.getAddressId()).orElse(null);
		if(updateAddress!=null)
		{
			return addressRepository.save(address);
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA +" : "+address.getAddressId());
		}
	}

	@Override
	public Address deleteAddress(long addressId) {
		Address deleteAddress=addressRepository.findById(addressId).orElse(null);
		if(deleteAddress!=null) {
			addressRepository.delete(deleteAddress);
			return deleteAddress;
		}
		else
			throw new OSException(UtilityClass.INVALID_DATA +" : "+addressId);
	}

	@Override
	public Address getAddressById(long addressId) {
	    Address address=addressRepository.findById(addressId).orElse(null);
		if(address!=null)
		{
			return address;
		}
		else {
			throw new OSException(UtilityClass.INVALID_DATA +" : "+addressId);
		}
	}

	@Override
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}

}

package com.cg.onlineshopping.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import com.cg.onlineshopping.entity.Address;

@SpringBootTest
 class AddressServiceTest {
	
	@Autowired
	AddressService service;
	
	@Test
	void addAddressTest()
	{
		Address address=new Address("Anna Nagar","MK main road","Coimbatore","TN","638412","home","india",null);
		Address newAddress=service.addAddress(address);
		assertEquals("Anna Nagar", newAddress.getAddressLine1());
	}
	
	@Test
	void updateAddressTest()
	{
		Address address=new Address("JT Nagar","cross cut road","Erode","TN","638412","home","India",null);
		Address oldAddress=service.addAddress(address);
		long id=oldAddress.getAddressId();
		Address newAddress=new Address(id,"ABC Nagar","cross cut road","Erode","Tamilnadu","638412","home","India",null);
		assertEquals("ABC Nagar", newAddress.getAddressLine1());
	}
	
	@Test
	void viewAddressByIdTest() 
	{
		Address address=new Address("Nehru cross street","7th cut road","Palani","Tamilnadu","638412","home","India",null);
		Address viewAddress=service.addAddress(address);
		long id=viewAddress.getAddressId();
		Address getAddress=service.getAddressById(id);
		assertEquals(id, getAddress.getAddressId());
	}
	
	@Test
	void viewAllAddressTest()
	{
		Address address1=new Address("OMR road","vellanoor","Nammakkal","Tamilnadu","638412","home","India",null);
		service.addAddress(address1);
		Address address2=new Address("SM nagar","sathy main road","Erode","Tamilnadu","638412","home","India",null);
		service.addAddress(address2);
		List<Address> address=service.getAllAddress();
		assertTrue(!address.isEmpty());
	}
	
	@Test
	void deleteAddressTest()
	{
		Address address=new Address("AM nagar","East street","Coimbatore","Tamilnadu","638412","home","India",null);
		Address oldAddress=service.addAddress(address);
		long id=oldAddress.getAddressId();
		Address deleteAddress=service.deleteAddress(id);
		assertEquals(id, deleteAddress.getAddressId());
	}
	
}

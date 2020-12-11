package com.cg.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineshopping.Service.AdminService;
import com.cg.onlineshopping.entity.Admin;
import com.cg.onlineshopping.exception.InvalidUserException;
import com.cg.onlineshopping.utility.UtilityClass;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin)
	{
		Admin admin1=adminService.createAdminPassword(admin);
		return new ResponseEntity<Admin>(admin1,HttpStatus.OK);
		
	}
	@PutMapping("")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin)
	{
		Admin admin1=adminService.updatePassword(admin);
		return new ResponseEntity<Admin>(admin1,HttpStatus.OK);
		
	}
	
	@GetMapping("/login/{role}/pass/{password}")
	public ResponseEntity<String> validateAdmin(@PathVariable("role") String role,@PathVariable("password") String password )
	{
		boolean isValid=adminService.validateAdmin(role, password);
		if(isValid)
		{
			return new ResponseEntity<String>("Welcome Admin",HttpStatus.OK);
		}
		else {
			throw new InvalidUserException(UtilityClass.INVALID_DATA);
		}
	}

}

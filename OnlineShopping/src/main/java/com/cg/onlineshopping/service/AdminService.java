package com.cg.onlineshopping.service;

import com.cg.onlineshopping.entity.AdminTable;

public interface AdminService {
	
	public AdminTable createAdminPassword(AdminTable admin);
	public AdminTable updatePassword(AdminTable admin);
	public boolean validateAdmin(String role,String password);

}

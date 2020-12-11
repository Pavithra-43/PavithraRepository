package com.cg.onlineshopping.Service;

import com.cg.onlineshopping.entity.Admin;

public interface AdminService {
	
	public Admin createAdminPassword(Admin admin);
	public Admin updatePassword(Admin admin);
	public boolean validateAdmin(String role,String password);

}

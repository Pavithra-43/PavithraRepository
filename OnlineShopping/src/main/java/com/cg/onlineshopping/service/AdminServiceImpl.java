package com.cg.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineshopping.entity.AdminTable;
import com.cg.onlineshopping.exception.InvalidUserException;
import com.cg.onlineshopping.repository.AdminJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminJpaRepository adminRepository;

	@Override
	public AdminTable createAdminPassword(AdminTable admin) {
		return adminRepository.save(admin);
	}

	@Override
	public AdminTable updatePassword(AdminTable admin) {
		AdminTable admin1=adminRepository.findById(admin.getAdminId()).orElse(null);
		if(admin1==null) {
			throw new InvalidUserException(UtilityClass.INVALID_DATA+" : " +admin.getAdminId() );
		}
		return adminRepository.save(admin);
	}

	@Override
	public boolean validateAdmin(String username, String password) {
		AdminTable admin=adminRepository.findByUsername(username);
		if(admin.getPassword().equals(password))
		{
			return true;
		}
		else {
			throw new InvalidUserException(UtilityClass.INVALID_DATA);
		}
	}

}

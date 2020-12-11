package com.cg.onlineshopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.Admin;
import com.cg.onlineshopping.exception.InvalidUserException;
import com.cg.onlineshopping.repository.AdminJpaRepository;
import com.cg.onlineshopping.utility.UtilityClass;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminJpaRepository adminRepository;

	@Override
	public Admin createAdminPassword(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin updatePassword(Admin admin) {
		Admin admin1=adminRepository.findById(admin.getAdminId()).orElse(null);
		if(admin1==null) {
			throw new InvalidUserException(UtilityClass.INVALID_DATA+" : " +admin.getAdminId() );
		}
		return adminRepository.save(admin);
	}

	@Override
	public boolean validateAdmin(String role, String password) {
		Admin admin=adminRepository.findByRole(role);
		if(admin.getPassword().equals(password))
		{
			return true;
		}
		else {
			throw new InvalidUserException(UtilityClass.INVALID_DATA);
		}
	}

}

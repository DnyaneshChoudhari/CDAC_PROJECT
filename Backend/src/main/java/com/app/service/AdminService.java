package com.app.service;

import java.util.Optional;

import com.app.entities.Admin;



public interface AdminService {

	 Optional<Admin> getAdminByEmail(String email);
}

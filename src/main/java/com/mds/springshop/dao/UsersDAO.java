package com.mds.springshop.dao;

import com.mds.springshop.entity.Users;

public interface UsersDAO {
	
	public Users findUserEmail(String email);
}
package com.mds.springshop.dao;

import com.mds.springshop.entity.Users;
import com.mds.springshop.model.UsersInfo;

public interface UsersDAO {
	
	public Users findUserByEmail(String email);
	public void save(UsersInfo userInfo);
}
package com.csii.demo.usr.dao.inter;

import com.csii.demo.usr.bean.User;

public interface UserDao {
	
	public User selectUserById(long userId);
	public User selectUserByUsername(String username);
}

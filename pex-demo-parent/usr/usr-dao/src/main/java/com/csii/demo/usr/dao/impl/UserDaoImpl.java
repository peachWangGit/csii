package com.csii.demo.usr.dao.impl;

import org.springframework.orm.ibatis.SqlMapClientOperations;

import com.csii.demo.usr.bean.User;
import com.csii.demo.usr.dao.inter.UserDao;

public class UserDaoImpl implements UserDao {
	
	private SqlMapClientOperations sqlMap;
	
	public SqlMapClientOperations getSqlMap() {
		return sqlMap;
	}

	public void setSqlMap(SqlMapClientOperations sqlMap) {
		this.sqlMap = sqlMap;
	}

	@Override
	public User selectUserById(long userId) {
		User user = (User) sqlMap.queryForObject("user.selectUserById", userId);
		return user;
	}

	@Override
	public User selectUserByUsername(String username) {
		User user = (User) sqlMap.queryForObject("user.selectUserByUsername", username);
		return user;
	}

}

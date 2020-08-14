package com.csii.demo.usr.action;

import com.csii.demo.usr.bean.User;
import com.csii.demo.usr.dao.inter.UserDao;
import com.csii.demo.usr.dao.mapper.UserMapper;
import com.csii.demo.utils.ConfigUtil;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginAction extends BaseQueryAction {

	private UserDao userDao;

	@Autowired
	private UserMapper userMapper;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

	@Override
	public void execute(Context context) throws PeException {
		
		System.out.println(ConfigUtil.getProperty("demo.workerId"));
		String loginType = context.getString("LoginType");
		String username = context.getString("Username");
		String password = context.getString("Password");
		//User user = userDao.selectUserByUsername(username);
		User user = userMapper.selectUserByUsername(username);
		if(user != null){
			if(loginType != null && loginType.equalsIgnoreCase("M")){
				context.setData("User", user);
			}else{
				if(password != null && password.equals(user.getPassword())){
					context.setData("User", user);
				}
			}
		}
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}

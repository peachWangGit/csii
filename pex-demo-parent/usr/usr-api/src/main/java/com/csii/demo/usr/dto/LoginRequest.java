package com.csii.demo.usr.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable{
	private static final long serialVersionUID = -2954178618461184769L;
	private String loginType;
	private String username;
	private String password;
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

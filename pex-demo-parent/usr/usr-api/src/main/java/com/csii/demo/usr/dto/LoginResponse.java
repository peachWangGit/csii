package com.csii.demo.usr.dto;

import java.io.Serializable;

import com.csii.demo.usr.bean.User;

public class LoginResponse implements Serializable{
	private static final long serialVersionUID = -3029657108095316877L;
	
	private User user;
	private String others;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	
}

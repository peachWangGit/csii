package com.csii.demo.usr.api;

import com.csii.demo.usr.dto.LoginRequest;
import com.csii.demo.usr.dto.LoginResponse;

public interface UserService {
	
	public LoginResponse login(LoginRequest request);
	
}

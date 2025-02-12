package com.food.service;

import javax.security.auth.login.LoginException;

import com.food.model.Login;


public interface LoginService {
	public String loginAccount (Login dto)throws LoginException;
	public String logoutAccount (String key)throws LoginException;

}


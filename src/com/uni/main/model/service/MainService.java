package com.uni.main.model.service;

import com.uni.login.service.LoginService;

public class MainService {
	LoginService loginService = new LoginService();
	public void exitProgram() {
		loginService.exitProgram();
	}
}

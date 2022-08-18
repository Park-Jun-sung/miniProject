package com.uni.login.service;

import static com.uni.common.JDBCTemplate.*;

import java.sql.Connection;

import com.uni.login.model.dao.LoginDAO;
import com.uni.member.model.dto.Member;

public class LoginService {
	LoginDAO loginDAO = new LoginDAO();
	
	public Member checkUser(Member member) {
		Connection conn = getConnection();
		Member m = loginDAO.checkUser(conn, member);
		return m; 
	}
	
	public void exitProgram() {
		close(getConnection());
	}
}

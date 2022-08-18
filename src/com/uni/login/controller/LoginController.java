package com.uni.login.controller;

import com.uni.login.service.LoginService;
import com.uni.member.model.dto.Member;

public class LoginController {
	private LoginService loginService = new LoginService();
	
	public Member checkUser(Member member) {
		String inputId = member.getMember_id();
		String inputPwd = member.getMember_pwd();
		
		Member m = loginService.checkUser(member);
		
		if(m.getMember_id() == null) {
			m = new Member();
			System.out.println(inputId + " 아이디가 없습니다.");
		}else {
			if(m.getMember_pwd() == null || !m.getMember_pwd().equals(inputPwd)) {
				m = new Member();
				System.out.println("비밀번호가 잘못되었습니다. 비밀번호를 확인해주세요.");
			}
		}
		
		return m;
	}

	public void exitProgram() {
		loginService.exitProgram();
	}
}

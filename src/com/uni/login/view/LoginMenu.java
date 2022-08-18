package com.uni.login.view;

import java.util.Scanner;

import com.uni.login.controller.LoginController;
import com.uni.main.view.MainMenu;
import com.uni.member.model.dto.Member;
import com.uni.member.view.MemberMenu;

public class LoginMenu {
	private static Scanner sc = new Scanner(System.in);
	private LoginController loginController = new LoginController();
	private Member member = new Member();
	
	public void mainMenu() {
		int choice;
		
		do {
			for(int i = 0; i < 3; i++) System.out.println();
			System.out.println(" ___  ___  _______   ___       ___       ________      ");
			System.out.println(" |\\  \\|\\  \\|\\  ___ \\ |\\  \\     |\\  \\     |\\   __  \\    ");
			System.out.println(" \\ \\  \\\\\\  \\ \\   __/|\\ \\  \\    \\ \\  \\    \\ \\  \\|\\  \\   ");
			System.out.println("  \\ \\   __  \\ \\  \\_|/_\\ \\  \\    \\ \\  \\    \\ \\  \\\\\\  \\  ");
			System.out.println("   \\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\____\\ \\  \\\\\\  \\ ");
			System.out.println("    \\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\");
			System.out.println("     \\|__|\\|__|\\|_______|\\|_______|\\|_______|\\|_______|");
			System.out.println();
			System.out.println();
			System.out.println("1. 로그인");
			System.out.println("2. 회원관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호선택 : ");

			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					new LoginMenu().login();
					
					break;
				case 2:
					new MemberMenu().mainMenu();
					break;
				case 0:
					System.out.print("정말로 끝내시겠습니까??(y/n) : ");
					if('y' == sc.next().toLowerCase().charAt(0)) {
						System.out.println("프로그램 종료");
						loginController.exitProgram();
						return;
					}
					break;
				default:
					System.out.println("번호를 잘못입력하였습니다.");
					break;
			}
		}while(true);
	}
	
	public void login() {
		this.member = loginController.checkUser(checkUser());
		if(this.member.getMember_no() != 0) {
			MainMenu.member = this.member;
			new MainMenu().mainMenu();
		}
	}
	
	public Member checkUser() {
		this.member.setMember_id(inputMemberId());
		this.member.setMember_pwd(inputMemberPwd());
		return this.member;
	}
	
	public String inputMemberId() {
		System.out.print("아이디입력 : ");
		return sc.next();
	}
	
	public String inputMemberPwd() {
		System.out.print("암호입력 : ");
		return sc.next();
	}
}

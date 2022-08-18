package com.uni.member.view;

import java.util.List;
import java.util.Scanner;

import com.uni.member.controller.MemberController;
import com.uni.member.model.dto.Member;

public class MemberMenu {
	private static Scanner sc = new Scanner(System.in);
	private MemberController memberController = new MemberController();

	public void mainMenu() {
		
		int choice;
		label:
		do {
			
			System.out.println("\n******* 회원 관리 프로그램 ********");
			System.out.println("     ___  ________  ___  ________           ___  ___  ________       ");
			System.out.println("    |\\  \\|\\   __  \\|\\  \\|\\   ___  \\        |\\  \\|\\  \\|\\   ____\\     ");
			System.out.println("    \\ \\  \\ \\  \\|\\  \\ \\  \\ \\  \\\\ \\  \\       \\ \\  \\\\\\  \\ \\  \\___|_    ");
			System.out.println("  __ \\ \\  \\ \\  \\\\\\  \\ \\  \\ \\  \\\\ \\  \\       \\ \\  \\\\\\  \\ \\_____  \\   ");
			System.out.println(" |\\  \\\\_\\  \\ \\  \\\\\\  \\ \\  \\ \\  \\\\ \\  \\       \\ \\  \\\\\\  \\|____|\\  \\  ");
			System.out.println(" \\ \\________\\ \\_______\\ \\__\\ \\__\\\\ \\__\\       \\ \\_______\\____\\_\\  \\ ");
			System.out.println("  \\|________|\\|_______|\\|__|\\|__| \\|__|        \\|_______|\\_________\\");
			System.out.println("                                                        \\|_________|");
			System.out.println("                                                                    ");
			System.out.println("1.회원 전체 조회");//SELECT
			System.out.println("2.회원 아이디 조회");//SELECT
			System.out.println("3.회원 이름 조회");//SELECT
			System.out.println("4.회원 가입");//INSERT
			System.out.println("5.회원 정보 변경");//UPDATE
			System.out.println("6.회원 탈퇴");// DELETE
			System.out.println("0.이전 메뉴");//종료
			System.out.print("번호선택 : ");
			
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					memberController.selectAll();
					break;
				case 2: 
					memberController.selectOne(inputMemberId());
					break;
				case 3: 
					memberController.selectByName(inputMemberName());
					break;
				case 4: 
					memberController.insertMember(inputMember());
					break;
				case 5: 
					memberController.updateMember(updateMember());
					break;
				case 6: 
					memberController.deleteMember(inputMemberId());
					break;
				case 0:
					break label;
				default:
					System.out.println("번호를 잘못입력하였습니다.");
		  		 break;
			}
		}while(true);
	}

	private Member updateMember() {
		Member m = new Member();
		
		m.setMember_id(inputMemberId());
		System.out.println("암호 : ");
		m.setMember_pwd(sc.next());
		System.out.println("이름 : ");
		m.setMember_name(sc.next());
		
		return m;
	}

	private Member inputMember() {
		Member m = new Member();
		System.out.println("새로운 회원정보를 입력하세요 >>");
		System.out.println("아이디 : ");
		m.setMember_id(sc.next());
		System.out.println("암호 : ");
		m.setMember_pwd(sc.next());
		System.out.println("이름 : ");
		m.setMember_name(sc.next());
		
		return m;
	}

	private String inputMemberName() {
		System.out.println("조회할 회원이름 입력 : ");
		return sc.next();
	}

	private String inputMemberId() {
		System.out.println("아이디입력 : ");
		return sc.next();
	}

	public void displayMemberMenu(List<Member> list) {
		System.out.println("\n조회된 전체 회원정보는 다음과 같습니다.");
		System.out.println("\n아이디\t비밀번호\t이름");
		System.out.println("----------------------------------------------------------");
		
		for(Member m : list) {
		System.out.println(m);
		}
	}

	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
	}

	public void displayMember(Member m) {
		System.out.println("\n조회된 회원정보는 다음과 같습니다.");
		System.out.println("\n아이디\t비밀번호\t이름");
		System.out.println("----------------------------------------------------------");
		System.out.println(m);
	}

	//성공 메세지 출력
	public void displaySuccess(String message) {
	   System.out.println("서비스 요청 결과 : "+message)  ;
	}

}

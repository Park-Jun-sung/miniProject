package com.uni.main.view;

import java.util.Scanner;

import com.uni.booking.view.BookingListMenu;
import com.uni.booking.view.BookingMenu;
import com.uni.member.model.dto.Member;

public class MainMenu {
	private static Scanner sc = new Scanner(System.in);
	public static Member member;

	public void mainMenu() {
//		System.out.println("로그인 확인 : " + member.toString());
		int choice;
		
		do {
			System.out.println("  _    _  _____  _      _____  _____  __  ___ ____ ");
			System.out.println(" | |  | ||  ___|| |    /  __ \\/  __ \\|  \\/  ||  __\\");
			System.out.println(" | |  | || |__  | |    | /  \\/| | | || .  . || |__  ");
			System.out.println(" | |/\\| ||  __| | |    | |    | | | || |\\/| ||  __| ");
			System.out.println(" \\  /\\  /| |___ | |____| \\__/\\\\ \\_/ /| |  | || |___ ");
			System.out.println("  \\/  \\/ \\____/ \\_____/ \\____/ \\___/ \\_|  |_/\\____/ ");
			System.out.println("  _____  _____            ___  _____    ___  _   _ ");
			System.out.println(" |_   _|/  __ \\          |_  ||  ___|  |_  || | | |");
			System.out.println("   | |  | | | |            | || |__      | || | | |");
			System.out.println("   | |  | | | |            | ||  __|     | || | | |");
			System.out.println("   | |  \\ \\_/ /        /\\__/ /| |___ /\\__/ /| |_| |");
			System.out.println("   \\_/   \\___/         \\____/ \\____/ \\____/  \\___/ ");
			System.out.println("");
			System.out.println("어서오세요 " + member.getMember_name() + " 님!");
			System.out.println("");
			System.out.println("1. 예약");
			System.out.println("2. 예약 정보 확인");
			System.out.println("3. 로그아웃");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1: 
					new BookingMenu().mainMenu();
					break;
				case 2:
					new BookingListMenu().mainMenu();
					break;
				case 3:
					System.out.println("로그아웃 되었습니다.");
					return;
				case 0:
					System.out.print("정말로 끝내시겠습니까??(y/n) : ");
					if('y' == sc.next().toLowerCase().charAt(0)) {
						System.out.println("프로그램 종료");
						System.exit(0);
						return;
					}
					break;
				default:
					System.out.println("번호를 잘못입력하였습니다.");
					break;
			}
			
		}while(true);
	}
	
}

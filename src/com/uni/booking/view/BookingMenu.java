package com.uni.booking.view;

import java.util.Scanner;

import com.uni.flight.view.FlightMenu;
import com.uni.rentCar.view.RentCarMenu;
import com.uni.spot.view.SpotMenu;
import com.uni.stay.view.StayMenu;

public class BookingMenu {
	
	private static Scanner sc = new Scanner(System.in);
	

	public void mainMenu() {
		
		int choice;
		
		do {
			System.out.println("\n****** 예약 관리 프로그램 ******");
			System.out.println("");
			System.out.println("1. 항공");
			System.out.println("2. 관광지");
			System.out.println("3. 렌터카");
			System.out.println("4. 숙박");
			System.out.println("0. 이전 화면");
			System.out.print("메뉴 선택 : ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
				case 1://항공
					new FlightMenu().mainMenu();
					break;
				case 2://관광지
					new SpotMenu().areaMenu();
					break;
				case 3://렌트카
					new RentCarMenu().RentCarMenu();
					break;
				case 4://숙박
					new StayMenu().areaMenu();
					break;
				case 0:
					return;
				default:
					System.out.println("번호를 잘못입력하였습니다.");
					break;
			}
		
		}while(true);
	}
	
}

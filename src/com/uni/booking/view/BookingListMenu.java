package com.uni.booking.view;

import java.util.Scanner;

import com.uni.booking.controller.BookingListController;

public class BookingListMenu {
	private BookingListController bookingListController = new BookingListController();
	private static Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		int choice;
		
		do {
			System.out.println("\n****** 예약 관리 프로그램 ******");
			System.out.println("");
			System.out.println("1. 전체 예약 조회");
			System.out.println("2. 항공 예약 조회");
			System.out.println("3. 관광지 예약 조회");
			System.out.println("4. 렌터카 예약 조회");
			System.out.println("5. 숙박 예약 조회");
			System.out.println("0. 이전 화면");
			System.out.print("메뉴 선택 : ");
			
			choice = sc.nextInt();
			
			switch(choice) {
				case 1://전체 예약 조회
					bookingListController.selectAllBookingList(member);
					break;
				case 2://항공 예약 조회
					bookingListController.selectFlightBookingList(member);
					break;
				case 3://관광지 예약 조회
					bookingListController.selectSpotBookingList(member);
					break;
				case 4://렌터가 예약 조회
					bookingListController.selectRentCarBookingList(member);
					break;
				case 5://숙박 예약 조회
					bookingListController.selectStayBookingList(member);
					break;
				case 0://이전 화면
					return;
				default:
					System.out.println("번호를 잘못입력하였습니다.");
					break;
			}
			
		}while(true);
	}
	
}

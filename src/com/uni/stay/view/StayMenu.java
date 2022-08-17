package com.uni.stay.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.uni.stay.controller.StayController;
import com.uni.stay.model.dto.BookingStay;
import com.uni.stay.model.dto.Stay;

public class StayMenu {

	private Scanner sc = new Scanner(System.in);
	
	private StayController stayController = new StayController();
	private BookingStay bookingStay = new BookingStay();
	
	public void areaMenu() {
		int areaChoice;
		String area = "";
		
		do {
			System.out.println("\n*******지역********");
			System.out.println("1.제주시");
			System.out.println("2.서귀포시");
			System.out.println("0.이전 화면");
			System.out.println("번호선택 : ");
			
			areaChoice = sc.nextInt();
			
			
			switch(areaChoice) {
			case 1: 
				area = "제주시";
				bookingStay.setStayArea(area);
				stayMenu();
				
				break;
			case 2:
				area = "서귀포시";
				bookingStay.setStayArea(area);
				stayMenu();	
				break;
			case 0:
				System.out.println("이전 화면으로 돌아갑니다.");
				//TODO
				break;
				
			default :
				System.out.println("번호를 잘못입력하였습니다.");
			}
			
			
		} while(true);
		
		
		
	}

	private void stayMenu() {
		int stayChoice;
		int code = 0; 
		
		do {
			System.out.println("\n*******숙박 구분********");
			System.out.println("1.펜션");
			System.out.println("2.호텔");
			System.out.println("3.리조트/콘도");
			System.out.println("4.기타");
			System.out.println("0.이전 화면");
			System.out.println("번호선택 : ");
			
			stayChoice = sc.nextInt();
			
			switch(stayChoice) {
			case 1: 
				code = 1;
				bookingStay.setStayCode(1);
				dayMenu();
				break;
			case 2: 
				code = 2;
				bookingStay.setStayCode(2);
				dayMenu();
				break;
			case 3: 
				code = 3;
				bookingStay.setStayCode(3);
				dayMenu();
				break;
			case 4: 
				code = 4;
				bookingStay.setStayCode(4);
				dayMenu();
				break;
			case 0:
				System.out.println("이전 화면으로 돌아갑니다.");
				areaMenu();
				break;
				
			default :
				System.out.println("번호를 잘못입력하였습니다.");
			}
			
			
		} while(true);
		
	}

	private void dayMenu() {
		int choice;
		
		do {
			System.out.println("\n*******입실 일자********");
			System.out.println("1.입실 일자 입력");
			System.out.println("0.이전 화면");
			System.out.println("번호선택 : ");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: 
				dayChoice();
				nameMenu();
				break;
			case 0:
				System.out.println("이전 화면으로 돌아갑니다.");
				stayMenu();
				break;
				
			default :
				System.out.println("번호를 잘못입력하였습니다.");
			}
			
			
		} while(true);
		
	}

	public void dayChoice() {
		
		System.out.println("입실 일자를 입력해 주세요 ( '-'빼고 년도월일 입력, ex)20220101 ): ");
		String bookingDate = sc.nextLine();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		
		Date transDate = null;
		try {
			transDate = formatter.parse(bookingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		bookingStay.setStayDay(transDate);
		
		
//		System.out.println(transDate);

//		System.out.println(bookingStay.getStayDay());
	}

	private void nameMenu() {
		int choice;
		
		do {
			System.out.println("\n*******숙소 목록 및 선택********");
			System.out.println("1.숙소 목록 및 선택");
			System.out.println("0.이전 화면");
			System.out.println("번호선택 : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1: 
				stayController.selectByNameList(bookingStay.getStayArea(), bookingStay.getStayCode());
				
				System.out.println("숙소를 선택해주세요 (숙소명 입력): ");
				String stayName = sc.nextLine();
				bookingStay.setStayName(stayName);
				
				infoMenu();
				break;
			case 0:
				System.out.println("이전 화면으로 돌아갑니다.");
				dayMenu();
				break;
				
			default :
				System.out.println("번호를 잘못입력하였습니다.");
			}
			
			
		} while(true);
		
		
	}

	private void infoMenu() {
		
		do {
			System.out.println("\n*******선택 숙소 정보********");
			System.out.println("1.선택 숙소 정보 확인");
			System.out.println("0.이전 화면");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			
			switch(choice) {
			case 1: 
				System.out.println("예약하시겠습니까?(y/n)");
				String booking = sc.nextLine();
				if(booking.equals("y")||booking.equals("Y")) {
					bookingMenu();
				}
				break;
			case 0:
				System.out.println("이전 화면으로 돌아갑니다.");
				nameMenu();
				break;
				
			default :
				System.out.println("번호를 잘못입력하였습니다.");
			}
			
			
		} while(true);
		
	}

	private void bookingMenu() {
		
		
		
		
	}

	public void displayStayList(List<Stay> s2) {
		System.out.println("다음은 숙소 목록 입니다");
		System.out.println("----------------------------------");
		System.out.println();
		int i = 1;
		
		for(Stay s : s2) {
			System.out.println(i++ + ". " + s.getStayName());
		}
	}

	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
		
	}

}

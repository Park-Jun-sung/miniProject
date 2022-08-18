package com.uni.spot.view;

import java.util.List;
import java.util.Scanner;

import com.uni.spot.controller.SpotController;
import com.uni.spot.model.dto.SpotDto;

import com.uni.main.view.MainMenu;

public class SpotMenu {
	
	MainMenu mainMenu = new MainMenu();

	private Scanner sc = new Scanner(System.in);
	SpotController spotcontroller = new SpotController();
	SpotDto dto = new SpotDto();
	
	
	
	public void areaMenu() {
		int city;
		
		
		do {
			System.out.println("\n*******지역********");
			System.out.println("1.제주시");
			System.out.println("2.서귀포시");
			System.out.println("0.이전 화면");
			System.out.print("번호선택 : ");
			
			
			city = sc.nextInt();
			
			
			switch(city) {
			case 1: 
				
				spotCategory(city);
				break;
			case 2:
				
				spotCategory(city);
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
	
	
	private void spotCategory(int city) {
		int spotChoice;
		int code = 0; 
		
		
		do {
			System.out.println("\n*******관광지 유형********");
			System.out.println("1.해수욕장");
			System.out.println("2.박물관");
			System.out.println("3.공원");
			System.out.println("4.전통시장");
			System.out.println("0.이전 화면");
			System.out.print("번호선택 : ");
			
			
			spotChoice = sc.nextInt();
			sc.nextLine();// 엔터입력받음
			System.out.println();
			
			switch(spotChoice) {
			case 1: 
				beachList(city);
				
				break;
			case 2: 
				museumList(city);
				break;
			case 3: 
				parkList(city);
				break;
			case 4: 
				marketList(city);
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

	
	
	
	
	

	
	/**
	 * <pre>
	 * 박물관 목록 조회
	 * </pre>
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	
	private void beachList(int city) {
		
		//해수욕장 목록 불러오기
		System.out.println("********해수욕장 목록********");
		spotcontroller.selectBeach(city);
	
		
		System.out.print("해수욕장을 선택해주세요(해수욕장명 입력) : ");
		String museumchoice = sc.nextLine();
		System.out.println();
	
		
		showAll(museumchoice);
		
	}
	
	
	
	private void museumList(int city) {
		
		System.out.println("********박물관 목록********");
		spotcontroller.selectMuseum(city);
	
		
		
		System.out.print("박물관을 선택해주세요(박물관명 입력) : ");
		String museumchoice = sc.nextLine();
		
		showAll(museumchoice);
		
	}
	
	private void parkList(int city) {
		
		
		System.out.println("********공원 목록********");
		spotcontroller.selectPark(city);
		
		
		System.out.print("공원을 선택해주세요 (공원명 입력): ");
		String museumchoice = sc.nextLine();
		
		showAll(museumchoice);
		
	}
	
	
	private void marketList(int city) {
		
		System.out.println("********전통시장 목록********");
		spotcontroller.selectMarket(city);
		
		
		System.out.print("전통시장을 선택해주세요 (전통시장명 입력): ");
		String museumchoice = sc.nextLine();
		
		showAll(museumchoice);
		
	}
	
	
	////////////////////////////////
	
	
	public void showAll(String spot) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("********선택관광지 정보********");
		spotcontroller.selectByName(spot);
		
		
		System.out.print(" 예약 하시겠습니까? (y/n) : ");
		
		String choice ;
		choice = sc.nextLine();
		System.out.println();
		
		if(choice.equals("y")) {
			
			reserve("y", spot);
			
		}
		
		
		
	}
	
	
	public void reserve (String choice , String spot) {
		
		System.out.println("*******예약 완료*******");
		spotcontroller.selectByName(spot);
		
		//예약정보 입력
		spotcontroller.bookingSpot(spot);
		
		System.out.println();
		System.out.println("       예약이 완료 되었습니다.      ");
		System.out.println("       Enter를 누르시면 메뉴로 돌아갑니다.      ");
		
		String menu = sc.nextLine();
		mainMenu.mainMenu();
		
		
	}
	
	

	

	
	/////////////////////////////////////
	
	
	
	public void displaySpotList(List<SpotDto> s2) {
	
	
		System.out.println();
		int i = 1;
		
		for(SpotDto s : s2) {
			
			if(s.getSpotArea().contains("제주시")) {
			System.out.println(i++ + ". " + s.getSpotName());
			}
		}
	}
	
	public void displaySpotList2(List<SpotDto> s2) {
		
		
		int i = 1;
		
		for(SpotDto s : s2) {
			
			if(s.getSpotArea().contains("서귀포시")) {
			System.out.println(i++ + ". " + s.getSpotName());
			}
		}
	}
	
	
	public void displaySpotList3(List<SpotDto> s2) {
		
	
		
		
		for(SpotDto s : s2) {
			
			System.out.println("- 관광지명 : " + s.getSpotName());
			System.out.println("- 위치   : " + s.getSpotArea());
			System.out.println("- 이용시간 : " + s.getSpotTime());
			System.out.println("- 입장요금 : " + s.getPrice());
			System.out.println();
		}
		
		
		
	
	}
	

	
	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
		
	}

	///////////////////////////////
	
	
	

	
}

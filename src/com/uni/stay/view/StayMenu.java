package com.uni.stay.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.uni.main.view.MainMenu;
import com.uni.stay.controller.StayController;
import com.uni.stay.model.dto.BookingStay;
import com.uni.stay.model.dto.Stay;

/**
 * <pre>
 * Class : 클래스의 이름
 * Comment : 클래스에 대한 설명
 * History
 * 2020/09/08 (작성자) 처음 작성함
 * </pre>
 * @author 작성자
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class StayMenu {

	private Scanner sc = new Scanner(System.in);
	
	private StayController stayController = new StayController();
	private BookingStay bookingStay = new BookingStay();
	private String[] date;
	private static String year;
	private static String month;
	private static String day;
	private static String tomorrow;
	private MainMenu mainMenu = new MainMenu();
	
	public void areaMenu() {
		int areaChoice;
		String area = "";
		
		do {
			System.out.println("\n==========지역==========");
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
				mainMenu.mainMenu();
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
			System.out.println("\n==========숙박 구분==========");
			System.out.println("1.펜션");
			System.out.println("2.호텔");
			System.out.println("3.리조트/콘도");
			System.out.println("4.기타");
			System.out.println("0.이전 화면");
			System.out.println("번호선택 : ");
			
			stayChoice = sc.nextInt();
			sc.nextLine();
			
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
			System.out.println("\n==========입실 일자==========");
			System.out.println("1.입실 일자 입력");
			System.out.println("0.이전 화면");
			System.out.println("번호선택 : ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
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
		
		System.out.println("입실 일자를 입력해 주세요 ( '-'구분자로 년도월일 입력, ex)2022-01-01 ): ");
		String bookingDate = sc.nextLine();
		
		date = bookingDate.split("-");
		year = date[0];
		month = date[1];
		day = date[2];
		
		int temp = Integer.parseInt(day);
		temp++; //날짜를 1일 추가
		
		tomorrow = Integer.toString(temp);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
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
			System.out.println("\n==========숙소 목록 및 선택==========");
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
			System.out.println("\n==========선택 숙소 정보==========");
			System.out.println("1.선택 숙소 정보 확인");
			System.out.println("0.이전 화면");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			
			switch(choice) {
			case 1: 
				stayController.selectByStayInfo(bookingStay.getStayArea(), bookingStay.getStayCode()
						,bookingStay.getStayDay() , bookingStay.getStayName());
				
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

		stayController.selectByBookingConfirmInfo(bookingStay.getStayArea(), bookingStay.getStayCode()
				,bookingStay.getStayDay() , bookingStay.getStayName());
		
		System.out.println("엔터를 눌러주시면 메뉴로 돌아갑니다.");
		String menu = sc.nextLine();
		mainMenu.mainMenu();
		
	}

	public void displayStayNameList(List<Stay> s2) {
		System.out.println();
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

	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public void displayStayInfoList(List<String> s2) {
		System.out.println();
		System.out.println("==========예약 정보==========");
		System.out.println();
		
		System.out.println("숙소명 : " + s2.get(0));
		System.out.println("주소 : " + s2.get(1));
		System.out.println("Check In : " + year + "년 " + month + "월 " + day + "일 15시00분 이후");
		System.out.println("Check Out : " + year + "년 " + month + "월 " + tomorrow + "일 11시00분 이전");
		System.out.println("금액 : " + s2.get(2) + "원");
	
		System.out.println();
		
		
	}

	public void displayBookingConfirm(List<String> s2) {
		System.out.println();
		System.out.println("==========예약 완료==========");
		System.out.println();
		
		System.out.println("숙소명 : " + s2.get(0));
		System.out.println("주소 : " + s2.get(1));
		System.out.println("Check In : " + year + "년 " + month + "월 " + day + "일 15시00분 이후");
		System.out.println("Check Out : " + year + "년 " + month + "월 " + tomorrow + "일 11시00분 이전");
		System.out.println("금액 : " + s2.get(2) + "원");
		System.out.println();
		System.out.println("숙소가 예약되었습니다.");
	}

}

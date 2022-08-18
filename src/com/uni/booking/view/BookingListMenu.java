package com.uni.booking.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.uni.booking.controller.BookingListController;
import com.uni.booking.model.dto.BookingDTO;
import com.uni.flight.model.dto.FlightDTO;
import com.uni.main.view.MainMenu;
import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.spot.model.dto.SpotDto;
import com.uni.stay.model.dto.Stay;

/**
 * <pre>
 * Class : BookingListMenu
 * Comment : 예약 현황 목록 출력 및 예약 취소
 * History
 * 2022/08/16 (박준성) 처음 작성함
 * </pre>
 * @author 박준성
 * @version 1.0.0
 * */
public class BookingListMenu {
	private BookingListController bookingListController = new BookingListController();
	private static Scanner sc = new Scanner(System.in);
	private static int totalPrice = 0;
	
	/**
	 * <pre>
	 * 예약 현황 목록 확인 및 예약 취소 메뉴 호출
	 * </pre>
	 */
	public void mainMenu() {
		
		int choice;
		
		do {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\n****** 예약 관리 프로그램 ******");
			System.out.println("");
			System.out.println("");
			bookingListController.selectFlightBookingList();
			bookingListController.selectSpotBookingList();
			bookingListController.selectRentCarBookingList();
			bookingListController.selectStayBookingList();
			System.out.println("");
			System.out.println("");
			System.out.println("1. 일괄 결제");
			System.out.println("2. 예약 취소");
			System.out.println("0. 이전 화면");
			System.out.print("메뉴 선택 : ");
			
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					bookingListController.setBookingPayment(setBookingPayment());
					break;
				case 2:
					bookingListController.setCancelBooking(setBookingNo());
					break;
				case 0:
					return;
				default:
					System.out.println("입력값을 확인해주세요.");
					break;
			}
			
			
		}while(true);
	}
	
	
	/**
	 * <pre>
	 * 예약을 취소할 예약번호 받아서 리턴하는 메소드
	 * </pre>
	 * @return bookingNo : 예약 취소할 예약 번호
	 */
	private int setBookingNo() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("====== 예약 취소 ======");
		System.out.print("취소할 예약번호를 입력해주세요 : ");
		int bookingNo = sc.nextInt();
		sc.nextLine();
		
		return bookingNo;
	}


	/**
	 * <pre>
	 * 일괄 결제 여부 받아서 리턴하는 메소드
	 * </pre>
	 * @return total : 예약 목록의 전체 합계 금액
	 */
	public int setBookingPayment() {
		int total = totalPrice;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("====== 예약 일괄 결제 ======");
		System.out.println("총 결제 금액 : " + totalPrice + " 원");
		System.out.print("결제하시겠습니까?(y/n) : ");
		
		char choice = sc.next().toLowerCase().charAt(0);

		if(choice != 'y') {
			total = 0;
		}
		
		return total;
	}
	
	
	/**
	 * <pre>
	 * 일괄결제 후 합계 금액 초기화 메소드
	 * </pre>
	 */
	public void initTotalPrice() {
		totalPrice = 0;
	}
	
	/**
	 * <pre>
	 * 결제 방식 선택하여 리턴하는 메소드
	 * </pre>
	 * @return 
	 */
	public int setPayCode() {
		do {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("==== 결제 방식 선택 ====");
			System.out.println("1. 현금");
			System.out.println("2. 카드");
			System.out.println("3. 무통장");
			System.out.print("선택 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
				case 2:
				case 3:
					return choice;
				default:
					System.out.println("입력값을 확인해주세요.");
					break;
			}
		}while(true);
	}
	
	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public void printBooking(BookingDTO b) {
		System.out.println("** 예약 정보 확인 **");
		System.out.print("예약번호[" + b.getBookingNo() + "]\t예약자[" + MainMenu.member.getMember_name() + "]\t예약일자[" + b.getBookingDay() + "]");
		System.out.println();
	}
	
	
	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public void printBookingList(ArrayList<BookingDTO> list) {
		for(BookingDTO booking : list) {
			int type = booking.getBookingSection();
			
			this.printBooking(booking);
			
			switch(type) {
				case 1://항공기
					FlightDTO flightDTO = booking.getFlight();
					System.out.println("< 항공기 예약 정보 >");
					System.out.print("항공기예약번호[" + flightDTO.getFlightNo() + "]");
					System.out.print("\t항공사[" + flightDTO.getFlightCompany() + "]");
					System.out.print("\t[" + flightDTO.getFlightAirportDeparture() + " -> " + flightDTO.getFlightAirportReturn() + "]");
					System.out.println("");
					System.out.print("출발일자[" + flightDTO.getFlightDeparture() + " " + flightDTO.getFlightTime() + "]");
					System.out.print("\t금액[" + flightDTO.getFlightPrice() + "원]");
					System.out.println("\n");
					
					totalPrice += flightDTO.getFlightPrice();
					break;
				case 2://관광지
					SpotDto spotDTO = booking.getSpot();
					System.out.println("< 관광지 예약 정보 >");
					System.out.println("- 관광지명 : " + spotDTO.getSpotName());
					System.out.println("- 위치   : " + spotDTO.getSpotArea());
					System.out.println("- 이용시간 : " + spotDTO.getSpotTime());
					System.out.println("- 입장요금 : " + spotDTO.getPrice() + "원");
					System.out.println("\n");
					
					totalPrice += spotDTO.getPrice();
					break;
				case 3://렌트카
					RentCarDto rentCarDTO = booking.getRentcar();
					System.out.println("< 렌터카 예약 정보 >");

					System.out.println("-------------------------------------------------------------------------------------------------------");
					System.out.print("\t렌트번호");
					System.out.print("\t\t\t차량번호");
					System.out.println("\t\t\t차종");
					System.out.println("\t" + rentCarDTO.getRentcar_no() + "\t\t\t" + rentCarDTO.getCar_no() + "\t\t\t" + rentCarDTO.getRentcar_model());
					
					System.out.println("-------------------------------------------------------------------------------------------------------");
					System.out.print("\t인수일자");
					System.out.print("\t\t\t인수시간");
					System.out.print("\t\t\t반납일자");
					System.out.println("\t\t\t반납시간");
					System.out.print("\t" + rentCarDTO.getRentcar_date());
					System.out.print("\t\t" + rentCarDTO.getRentcar_datetime());
					System.out.print("\t\t" + rentCarDTO.getRentcar_enddate());
					System.out.println("\t\t" + rentCarDTO.getRentcar_endtime());
					
					System.out.println("-------------------------------------------------------------------------------------------------------");
					System.out.print("\t대여기간");
					System.out.print("\t가격");
					System.out.print("\t분류");
					System.out.print("\t연료");
					System.out.print("\t정원");
					System.out.println("\t연식");
					
					System.out.print("\t" + rentCarDTO.getRentcar_renttime());
					System.out.print("\t" + rentCarDTO.getRentcar_price());
					System.out.print("\t" + rentCarDTO.getRentcar_section());
					System.out.print("\t" + rentCarDTO.getRentcar_fuel());
					System.out.print("\t" + rentCarDTO.getRentcar_limit());
					System.out.println("\t" + rentCarDTO.getRentcar_time());
					
					System.out.print("-------------------------------------------------------------------------------------------------------");
					
					System.out.println("\n");
					
					totalPrice += rentCarDTO.getRentcar_price();
					break;
				case 4://숙박
					Stay stayDTO = booking.getStay();
					
					String[] day1 = (""+stayDTO.getStayDay()).split("-");
					
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					
					cal.set(Integer.parseInt(day1[0]), Integer.parseInt(day1[1]), Integer.parseInt(day1[2]));
					
					cal.add(Calendar.DATE, 1);
					String[] day2 = sf.format(cal.getTime()).split("-");
					
					System.out.println("< 숙박 예약 정보 >");
					System.out.println("숙소명 : " + stayDTO.getStayName());
					System.out.println("주소 : " + stayDTO.getStayArea());
					System.out.println("Check In : " + day1[0] + "년 " + day1[1] + "월 " + day1[2] + "일 15시00분 이후");
					System.out.println("Check Out : " + day2[0] + "년 " + day2[1] + "월 " + day2[2] + "일 11시00분 이전");
					System.out.println("금액 : " + stayDTO.getPrice() + "원");
					System.out.println("\n");
					
					totalPrice += stayDTO.getPrice();
					break;
				default:
					break;
			}
		}
	}
	
	/**
	 * <pre>
	 * 서비스 요청 처리 실패 메시지 출력
	 * </pre>
	 * @param message : 출력할 메시지 정보
	 */
	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
	}
	
	
	/**
	 * <pre>
	 * 서비스 요청 처리 성공 메시지 출력
	 * </pre>
	 * @param message : 출력할 메시지 정보
	 */
	public void displaySuccess(String message) {
	   System.out.println("서비스 요청 결과 : "+message)  ;
	}
}

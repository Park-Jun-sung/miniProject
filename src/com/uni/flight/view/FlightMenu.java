package com.uni.flight.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.uni.flight.controller.FlightController;
import com.uni.flight.model.dto.FlightBookingDTO;
import com.uni.flight.model.dto.FlightDTO;

public class FlightMenu {
	private FlightController flightController = new FlightController();
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * <pre>
	 * 항공기 예약 메인 메뉴
	 * </pre>
	 */
	public void mainMenu() {
		int choice;
		
		do {
			FlightBookingDTO flightBookingDTO = flightController.displayFlightBookingInfo();
			
			String flightDeparture = flightBookingDTO.getFlightDeparture();//출발일자
			int travelPeriod = flightBookingDTO.getTravelPeriod();//여행기간
			String flightAirport = flightBookingDTO.getFlightAirport();//출발공항
			FlightDTO departureFlight = flightBookingDTO.getDepartureFlight();//출발항공기정보
			FlightDTO returnFlight = flightBookingDTO.getReturnFlight();//복귀항공기정보
			int flightPeoples = flightBookingDTO.getFlightPeoples();
			
			System.out.println("1. 출발 일자 입력");
			if(flightDeparture != null)
				System.out.println("2. 여행 기간 입력");
			if(travelPeriod != 0)
				System.out.println("3. 출발 공항 입력");
			if(flightAirport != null)
				System.out.println("4. 가는편 선택");
			if(departureFlight != null)
				System.out.println("5. 오는편 선택");
			if(returnFlight != null)
				System.out.println("6. 인원 입력");
			if(flightPeoples != 0)
				System.out.println("7. 예약 하기");
			System.out.println("0. 이전 화면");
			System.out.print("메뉴 선택 : ");
			
			choice = sc.nextInt(); 
			sc.nextLine();
			
			switch(choice){
				case 1://출발 일자 입력
//					setFlightDeparture();
					flightController.setFlightDeparture();
					break;
				case 2://여행 기간 입력
//					setTravelPeriod();
					flightController.setTravelPeriod();
					break;
				case 3://출발 공항 입력
//					setFlightAirport();
					flightController.setFlightAirport();
					break;
				case 4://가는편 선택
//					setDepartureFlight();
					flightController.setDepartureFlightList();
					break;
				case 5://오는편 선택
//					setReturnFlight();
					flightController.setReturnFlightList();
					break;
				case 6://인원 선택
//					setFlightPeoples();
					flightController.setFlightPeoples();
					break;
				case 7://예약 하기
//					insertBooking();
					flightController.insertBooking();
					break;
				case 0:
					return;
				default:
					System.out.println("번호를 잘못입력하였습니다.");
					break;
			}
		
		}while(true);
	}
	
	
	public void displayFlightBookingInfo(FlightBookingDTO flightBookingDTO) {
		String flightDeparture = flightBookingDTO.getFlightDeparture();//출발일자
		int travelPeriod = flightBookingDTO.getTravelPeriod();//여행기간
		String flightAirport = flightBookingDTO.getFlightAirport();//출발공항
		FlightDTO departureFlight = flightBookingDTO.getDepartureFlight();//출발항공기정보
		FlightDTO returnFlight = flightBookingDTO.getReturnFlight();//복귀항공기정보
		int flightPeoples = flightBookingDTO.getFlightPeoples();
		
		System.out.println("\n****** 항공기 예약 프로그램 ******");
		System.out.println("\n==== 항공편 검색 정보 ====");
		System.out.println("출발 일자 : " + (flightDeparture == null ? "미정" : flightDeparture));
		System.out.println("여행 기간 : " + (travelPeriod == 0 ? "미정" : ((travelPeriod - 1) + "박 " + travelPeriod + " 일")));
		System.out.println("출발 공항 : " + (flightAirport == null ? "미정" : flightAirport));
		System.out.println("가는편 선택 : " + (departureFlight == null ? "미정" : (	departureFlight.getFlightCompany() + " " + 
																				departureFlight.getFlightAirportDeparture() + "->" + 
																				departureFlight.getFlightAirportReturn() + " " + 
																				departureFlight.getFlightTime()) ));
		System.out.println("오는편 선택 : " + (returnFlight == null ? "미정" : (	returnFlight.getFlightCompany() + " " + 
																				returnFlight.getFlightAirportDeparture() + "->" + 
																				returnFlight.getFlightAirportReturn() + " " + 
																				returnFlight.getFlightTime()) ));
		System.out.println("인원 : " + (flightPeoples + " 명"));
		System.out.println("========================");
	}


	/**
	 * <pre>
	 * 항공기 예약 조건 - 출발일자 선택
	 * </pre>
	 */
	public void setFlightDeparture(FlightBookingDTO flightBookingDTO) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("출발 일자를 입력해주세요");
		System.out.println("예) 2022-08-01");
		System.out.print("입력 : ");
		String flightDeparture = sc.next();
		
		if(flightDeparture.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			flightBookingDTO.setFlightDeparture(flightDeparture);
		}else {
			System.out.println("입력값을 확인해주세요.");
		}
		return;
	}

	/**
	 * <pre>
	 * 항공기 예약 조건 - 여행 기간 선택
	 * </pre>
	 */
	public void setTravelPeriod(FlightBookingDTO flightBookingDTO) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("여행 기간을 입력해주세요");
		System.out.println("예)\t1박2일 -> 2");
		System.out.println("\t2박3일 -> 3");
		System.out.println("※ 최소 1박2일 에서 최대 4박5일");
		System.out.print("입력 : ");
		int travelPeriod = sc.nextInt();
		sc.nextLine();
		
		if(travelPeriod >= 2 && travelPeriod <= 5) {
			flightBookingDTO.setTravelPeriod(travelPeriod);
		}else {
			System.out.println("입력값을 확인해주세요.");
		}
	}
	
	/**
	 * <pre>
	 * 항공기 예약 조건 - 출발 공항 선택
	 * </pre>
	 */
	public void setFlightAirport(FlightBookingDTO flightBookingDTO) {
		int choice;
		
		do {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("출발 공항을 선택해주세요");
			System.out.println("1. 김포");
			System.out.println("2. 부산");
			System.out.print("선택 : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					flightBookingDTO.setFlightAirport("김포");
					return;
				case 2:
					flightBookingDTO.setFlightAirport("부산");
					return;
				default:
					System.out.println("입력값을 확인해주세요.");
					break;
			}
			
			
		}while(true);
	}
	
	/**
	 * <pre>
	 * 항공기 예약 시 출발항공기 선택 메소드
	 * </pre>
	 * @param list : 조회된 항공기 정보
	 */
	public void setDepartureFlight(FlightBookingDTO flightBookingDTO, ArrayList<FlightDTO> list) {
		System.out.println();
		System.out.println();
		System.out.println();
		
		if(list.size() > 0) {
			System.out.println("====== 항공기예약번호를 선택해주세요 ======");
			System.out.println();
			
			for(int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).toString());
				FlightDTO flight = list.get(i);
				System.out.print("항공기예약번호[" + flight.getFlightNo() + "]");
				System.out.print("\t항공사[" + flight.getFlightCompany() + "]");
				System.out.print("\t[" + flight.getFlightAirportDeparture() + " -> " + flight.getFlightAirportReturn() + "]");
				System.out.println("");
				System.out.print("출발일자[" + flight.getFlightDeparture() + " " + flight.getFlightTime() + "]");
				System.out.print("\t금액[" + flight.getFlightPrice() + "]");
				System.out.println("");
				System.out.println("");
			}
			
			System.out.println();
			System.out.println("================================");
			System.out.print("항공기예약번호 : ");
			int flightNo = sc.nextInt();
			sc.nextLine();
			
			for(int i = 0; i < list.size(); i++) {
				FlightDTO flightInfo = list.get(i);
				if(flightInfo.getFlightNo() == flightNo) {
					flightBookingDTO.setDepartureFlight(flightInfo);
				}
			}
		}
	}
	
	
	/**
	 * <pre>
	 * 항공기 예약 시 복귀 항공기 선택 메소드
	 * </pre>
	 * @param list : 조회된 항공기 정보
	 */
	public void setReturnFlight(FlightBookingDTO flightBookingDTO, ArrayList<FlightDTO> list) {
		System.out.println();
		System.out.println();
		System.out.println();
		if(list.size() > 0) {
			System.out.println("====== 항공기예약번호를 선택해주세요 ======");
			System.out.println();
			
			for(int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).toString());
				FlightDTO flight = list.get(i);
				System.out.print("항공기예약번호[" + flight.getFlightNo() + "]");
				System.out.print("\t항공사[" + flight.getFlightCompany() + "]");
				System.out.print("\t[" + flight.getFlightAirportDeparture() + " -> " + flight.getFlightAirportReturn() + "]");
				System.out.println("");
				System.out.print("출발일자[" + flight.getFlightDeparture() + " " + flight.getFlightTime() + "]");
				System.out.print("\t금액[" + flight.getFlightPrice() + "]");
				System.out.println("");
				System.out.println("");
			}
			
			System.out.println();
			System.out.println("================================");
			System.out.print("항공기예약번호 : ");
			int flightNo = sc.nextInt();
			sc.nextLine();
			
			for(int i = 0; i < list.size(); i++) {
				FlightDTO flightInfo = list.get(i);
				if(flightInfo.getFlightNo() == flightNo) {
					flightBookingDTO.setReturnFlight(flightInfo);
				}
			}
		}
	}
	
	
	/**
	 * <pre>
	 * 항공기 예약 조건 - 탑승 인원 선택
	 * </pre>
	 */
	public void setFlightPeoples(FlightBookingDTO flightBookingDTO) {
		do {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("====== 인원수를 입력해주세요 ======");
			System.out.print("입력 : ");
			int flightPeoples = sc.nextInt();
			sc.nextLine();
			
			if(flightPeoples > 0) {
				flightBookingDTO.setFlightPeoples(flightPeoples);
				break;
			}else {
				System.out.println("입력값을 확인해주세요.");
			}
			
		}while(true);
	}
	
	
	/**
	 * <pre>
	 * 예약 정보를 예약 테이블에 입력
	 * </pre>
	 */
	public char insertBooking(FlightBookingDTO flightBookingDTO) {
		FlightDTO departureFlight = flightBookingDTO.getDepartureFlight();
		FlightDTO returnFlight = flightBookingDTO.getReturnFlight();
		
		//
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("====== 항공기 예약 정보 확인 ======");
		System.out.println("출발일자 : " + flightBookingDTO.getFlightDeparture());
		System.out.println("여행 기간 : " + ((flightBookingDTO.getTravelPeriod() - 1) + "박 " + flightBookingDTO.getTravelPeriod() + " 일"));
		System.out.println("인원 : " + (flightBookingDTO.getFlightPeoples() + " 명"));
		System.out.println("[가는편]");
		System.out.print("항공기예약번호[" + departureFlight.getFlightNo() + "]");
		System.out.print("\t항공사[" + departureFlight.getFlightCompany() + "]");
		System.out.print("\t[" + departureFlight.getFlightAirportDeparture() + " -> " + departureFlight.getFlightAirportReturn() + "]");
		System.out.println();
		System.out.print("출발일자[" + departureFlight.getFlightDeparture() + " " + departureFlight.getFlightTime() + "]");
		System.out.print("\t금액[" + departureFlight.getFlightPrice() + "]");
		System.out.println();
		System.out.println("[오는편]");
		System.out.print("항공기예약번호[" + returnFlight.getFlightNo() + "]");
		System.out.print("\t항공사[" + returnFlight.getFlightCompany() + "]");
		System.out.print("\t[" + returnFlight.getFlightAirportDeparture() + " -> " + returnFlight.getFlightAirportReturn() + "]");
		System.out.println();
		System.out.print("출발일자[" + returnFlight.getFlightDeparture() + " " + returnFlight.getFlightTime() + "]");
		System.out.print("\t금액[" + returnFlight.getFlightPrice() + "]");
		System.out.println();
		System.out.println("==============================");
		System.out.println("총 비용 : " + ((departureFlight.getFlightPrice() + returnFlight.getFlightPrice()) * flightBookingDTO.getFlightPeoples()) + " 원");
		System.out.println("==============================");
		System.out.print("예약하시겠습니까?(y/n) : ");
		
		char choice = sc.next().toLowerCase().charAt(0);
		
		return choice;
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

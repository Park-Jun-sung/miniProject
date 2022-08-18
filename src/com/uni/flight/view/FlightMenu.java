package com.uni.flight.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.uni.flight.controller.FlightController;
import com.uni.flight.model.dto.FlightBookingDTO;
import com.uni.flight.model.dto.FlightDTO;

public class FlightMenu {
	private FlightController flightController = new FlightController();
	
	private FlightBookingDTO flightBookingDTO = new FlightBookingDTO();
	
	
	private static Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		int choice;
		
		do {
			String flightDeparture = flightBookingDTO.getFlightDeparture();//출발일자
			int travelPeriod = flightBookingDTO.getTravelPeriod();//여행기간
			String flightAirport = flightBookingDTO.getFlightAirport();//출발공항
			FlightDTO departureFlight = flightBookingDTO.getDepartureFlight();//출발항공기정보
			FlightDTO returnFlight = flightBookingDTO.getReturnFlight();//복귀항공기정보
			int flightPeoples = flightBookingDTO.getFlightPeoples();
			
			System.out.println("\n****** 항공기 예약 프로그램 ******");
			System.out.println("\n==== 항공편 검색 정보 ====");
			System.out.println("출발 일자 : " + (flightDeparture == null ? "없음" : flightDeparture));
			System.out.println("여행 기간 : " + (travelPeriod + " 일"));
			System.out.println("출발 공항 : " + (flightAirport == null ? "없음" : flightAirport));
			System.out.println("가는편 선택 : " + (departureFlight == null ? "없음" : departureFlight.toString()));
			System.out.println("오는편 선택 : " + (returnFlight == null ? "없음" : returnFlight.toString()));
			System.out.println("인원 : " + (flightPeoples + " 명"));
			System.out.println("========================");
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
					setFlightDeparture();
					break;
				case 2://여행 기간 입력
					setTravelPeriod();
					break;
				case 3://출발 공항 입력
					setFlightAirport();
					break;
				case 4://가는편 선택
					setDepartureFlight();
					break;
				case 5://오는편 선택
					setReturnFlight();
					break;
				case 6://인원 선택
					setFlightPeoples();
					break;
				case 7://예약 내용 확인
					break;
				case 0:
					return;
				default:
					System.out.println("번호를 잘못입력하였습니다.");
					break;
			}
		
		}while(true);
	}


	private void setFlightDeparture() {
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

	private void setTravelPeriod() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("여행 기간을 입력해주세요");
		System.out.println("예)\t1박2일 -> 2");
		System.out.println("\t2박3일 -> 3");
		System.out.println("※ 최대 4박5일");
		System.out.print("입력 : ");
		int travelPeriod = sc.nextInt();
		sc.nextLine();
		
		if(travelPeriod >= 1 && travelPeriod <= 5) {
			flightBookingDTO.setTravelPeriod(travelPeriod);
		}else {
			System.out.println("입력값을 확인해주세요.");
		}
	}
	
	private void setFlightAirport() {
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
	
	private void setDepartureFlight() {
		System.out.println();
		System.out.println();
		System.out.println();
		ArrayList<FlightDTO> list = flightController.getDepartureFlightList(flightBookingDTO);
		if(list.size() > 0) {
			System.out.println("====== 항공기번호를 선택해주세요 ======");
			System.out.println();
			
			for(int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).toString());
				FlightDTO dto = list.get(i);
				System.out.print("항공기예약번호[" + dto.getFlightNo() + "]");
				System.out.print("\t항공사[" + dto.getFlightCompany() + "]");
				System.out.print("\t[" + dto.getFlightAirportDeparture() + " -> " + dto.getFlightAirportReturn() + "]");
				System.out.println("");
				System.out.print("출발일자[" + dto.getFlightDeparture() + " " + dto.getFlightTime() + "]");
				System.out.print("\t가격[" + dto.getFlightPrice() + "]");
				System.out.println("");
			}
			
			System.out.println();
			System.out.println("================================");
			System.out.print("항공기예약번호 : ");
			int flightNo = sc.nextInt();
			sc.nextLine();
			
			
		}
		
	}
	
	private void setReturnFlight() {
		
	}
	
	private void setFlightPeoples() {
		
	}
}

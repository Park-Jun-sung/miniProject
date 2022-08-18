package com.uni.flight.controller;

import java.util.ArrayList;

import com.uni.flight.model.dto.FlightBookingDTO;
import com.uni.flight.model.dto.FlightDTO;
import com.uni.flight.model.service.FlightService;
import com.uni.flight.view.FlightMenu;

/**
 * <pre>
 * Class : FlightController
 * Comment : 항공기 예약 콘트롤러
 * History
 * 2022/08/16 (박준성) 처음 작성함
 * </pre>
 * @author 박준성
 * @version 1.0.0
 * */
public class FlightController {
	private FlightService flightService = new FlightService();
	private FlightBookingDTO flightBookingDTO = new FlightBookingDTO();

	/**
	 * <pre>
	 * 항공 예약 정보 출력
	 * </pre>
	 */
	public FlightBookingDTO displayFlightBookingInfo() {
		FlightMenu menu = new FlightMenu();
		menu.displayFlightBookingInfo(flightBookingDTO);
		return flightBookingDTO;
	}

	/**
	 * <pre>
	 * 출발일자 설정
	 * </pre>
	 */
	public void setFlightDeparture() {
		FlightMenu menu = new FlightMenu();
		menu.setFlightDeparture(flightBookingDTO);
	}

	/**
	 * <pre>
	 * 여행기간 설정
	 * </pre>
	 */
	public void setTravelPeriod() {
		FlightMenu menu = new FlightMenu();
		menu.setTravelPeriod(flightBookingDTO);
	}

	/**
	 * <pre>
	 * 출발 공항 설정
	 * </pre>
	 */
	public void setFlightAirport() {
		FlightMenu menu = new FlightMenu();
		menu.setFlightAirport(flightBookingDTO);
	}
	
	/**
	 * <pre>
	 * 출발 항공기 설정
	 * </pre>
	 */
//	public ArrayList<FlightDTO> getDepartureFlightList(FlightBookingDTO flightBookingDTO) {
//		ArrayList<FlightDTO> list = flightService.selectFlightDepartureList(flightBookingDTO);
//		
//		return list;
//	}
	
	public void setDepartureFlightList() {
		FlightMenu menu = new FlightMenu();
		;
		ArrayList<FlightDTO> list = flightService.selectFlightDepartureList(flightBookingDTO);
		
		if(list.size() > 0) {
			menu.setDepartureFlight(flightBookingDTO, list);
		}else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
	}

	/**
	 * <pre>
	 * 도착 항공기 설정
	 * </pre>
	 */
	public void setReturnFlightList() {
		FlightMenu menu = new FlightMenu();
		ArrayList<FlightDTO> list = flightService.selectFlightReturnList(flightBookingDTO);
		
		if(list.size() > 0) {
			menu.setReturnFlight(flightBookingDTO, list);
		}else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
	}

	/**
	 * <pre>
	 * 인원수 설정
	 * </pre>
	 */
	public void setFlightPeoples() {
		FlightMenu menu = new FlightMenu();
		menu.setFlightPeoples(flightBookingDTO);
	}

	/**
	 * <pre>
	 * 항공 예약 정보 기반으로 항공예약
	 * </pre>
	 */
	public void insertBooking() {
		FlightMenu menu = new FlightMenu();
		char choice = menu.insertBooking(flightBookingDTO);
		if(choice == 'y') {
			boolean result = flightService.insertBooking(flightBookingDTO);
			if(result) {
				menu.displaySuccess("항공기 정보가 예약되었습니다.");
				//예약 성공 후 기본 정보 초기화
				flightBookingDTO = new FlightBookingDTO();
			}else {
				menu.displayError("항공기 예약에 실패했습니다.");
			}
		}else {
			menu.displaySuccess("항공기 예약을 취소합니다.");
		}
		
	}

}

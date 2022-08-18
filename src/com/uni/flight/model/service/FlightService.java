package com.uni.flight.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.uni.flight.model.dao.FlightDAO;
import com.uni.flight.model.dto.FlightBookingDTO;
import com.uni.flight.model.dto.FlightDTO;

import static com.uni.common.JDBCTemplate.*;

/**
 * <pre>
 * Class : FlightService
 * Comment : 항공 예약 서비스
 * History
 * 2022/08/16 (박준성) 처음 작성함
 * </pre>
 * @author 박준성
 * @version 1.0.0
 * */
public class FlightService {
	
	private FlightDAO flightDAO = new FlightDAO();

	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param flightBookingDTO : 항공 예약 정보
	 * @return 출발지에서 출발하는 항공기 목록
	 */
	public ArrayList<FlightDTO> selectFlightDepartureList(FlightBookingDTO flightBookingDTO) {
		Connection conn = getConnection();
		ArrayList<FlightDTO> list = flightDAO.selectFlightDepartureList(conn, flightBookingDTO);
		
		return list;
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param flightBookingDTO : 항공 예약 정보
	 * @return 제주에서 돌아가는 항공기 목록
	 */
	public ArrayList<FlightDTO> selectFlightReturnList(FlightBookingDTO flightBookingDTO) {
		Connection conn = getConnection();
		ArrayList<FlightDTO> list = flightDAO.selectFlightReturnList(conn, flightBookingDTO);
		
		return list;
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param flightBookingDTO : 항공 예약 정보
	 * @return 항공 예약 정보 INSERT 결과
	 */
	public boolean insertBooking(FlightBookingDTO flightBookingDTO) {
		Connection conn = getConnection();
		boolean result = flightDAO.insertBooking(conn, flightBookingDTO);
		if(result) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
}

package com.uni.flight.model.dao;

import static com.uni.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.flight.model.dto.FlightBookingDTO;
import com.uni.flight.model.dto.FlightDTO;
import com.uni.main.view.MainMenu;

public class FlightDAO {

	/**
	 * <pre>
	 * 출발지에서 출발하는 항공기 목록 조회
	 * </pre>
	 * @param conn : 커낵션 객체
	 * @param flightBookingDTO : 항공 예약 정보 DTO 
	 * @return 출발 공항에서 출발하는 항공기에 대하여 FlightDTO객체형 리스트 리턴
	 * @exception SQL예외 처리
	 */
	public ArrayList<FlightDTO> selectFlightDepartureList(Connection conn, FlightBookingDTO flightBookingDTO) {
		ArrayList<FlightDTO> list = new ArrayList<FlightDTO>();
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql =	"SELECT flight_no"
					+	"     , air_no"
					+ 	"     , flight_company"
					+ 	"     , flight_departure"
					+ 	"     , flight_airport_departure"
					+ 	"     , flight_airport_return"
					+ 	"     , flight_time"
					+ 	"     , flight_price"
					+ 	"  FROM flight"
					+ 	" WHERE flight_departure like ?"
					+ 	"   AND flight_airport_departure = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, flightBookingDTO.getFlightDeparture()+"%");
			pstmt.setString(2, flightBookingDTO.getFlightAirport());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				FlightDTO flightDTO = new FlightDTO();
				flightDTO.setFlightNo(rset.getInt("flight_no"));
				flightDTO.setAirNo(rset.getInt("air_no"));
				flightDTO.setFlightCompany(rset.getString("flight_company"));
				flightDTO.setFlightDeparture(rset.getString("flight_departure"));
				flightDTO.setFlightAirportDeparture(rset.getString("flight_airport_departure"));
				flightDTO.setFlightAirportReturn(rset.getString("flight_airport_return"));
				flightDTO.setFlightTime(rset.getString("flight_time"));
				flightDTO.setFlightPrice(rset.getInt("flight_price"));
				
				list.add(flightDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * <pre>
	 * 제주에서 출발지로 복귀하는 항공기 목록
	 * 출발일자에서 여행기간만큼 계산된 일자의 리스트 작성
	 * 항공사는 출발지에서 선택했던 항공사로 제한하여 리스트 작성
	 * </pre>
	 * @param conn : 커낵션 객체
	 * @param flightBookingDTO : 항공 예약 정보 DTO 
	 * @return 제주 공항에서 출발하여 출발지로 복귀하는 항공기에 대하여 FlightDTO객체형 리스트 리턴
	 * @exception SQL예외 처리
	 */
	public ArrayList<FlightDTO> selectFlightReturnList(Connection conn, FlightBookingDTO flightBookingDTO) {
		ArrayList<FlightDTO> list = new ArrayList<FlightDTO>();
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql =	"SELECT flight_no"
					+	"     , air_no"
					+ 	"     , flight_company"
					+ 	"     , flight_departure"
					+ 	"     , flight_airport_departure"
					+ 	"     , flight_airport_return"
					+ 	"     , flight_time"
					+ 	"     , flight_price"
					+ 	"  FROM flight"
					+ 	" WHERE flight_departure LIKE DATE_ADD(?, INTERVAL ? DAY)"
					+ 	"   AND flight_airport_departure = ?"
					+ 	"   AND flight_airport_return = ?"
					+ 	"   AND flight_company = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, flightBookingDTO.getFlightDeparture()+"%");
			pstmt.setInt(2, flightBookingDTO.getTravelPeriod() - 1);
			pstmt.setString(3, "제주");
			pstmt.setString(4, flightBookingDTO.getDepartureFlight().getFlightAirportDeparture());
			pstmt.setString(5, flightBookingDTO.getDepartureFlight().getFlightCompany());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				FlightDTO flightDTO = new FlightDTO();
				flightDTO.setFlightNo(rset.getInt("flight_no"));
				flightDTO.setAirNo(rset.getInt("air_no"));
				flightDTO.setFlightCompany(rset.getString("flight_company"));
				flightDTO.setFlightDeparture(rset.getString("flight_departure"));
				flightDTO.setFlightAirportDeparture(rset.getString("flight_airport_departure"));
				flightDTO.setFlightAirportReturn(rset.getString("flight_airport_return"));
				flightDTO.setFlightTime(rset.getString("flight_time"));
				flightDTO.setFlightPrice(rset.getInt("flight_price"));
				
				list.add(flightDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception SQL예외 처리
	 */
	public boolean insertBooking(Connection conn, FlightBookingDTO flightBookingDTO) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		boolean result = false;
		int departureResult = 0;
		int returnResult = 0;
		
		try {
			//출발 항공기 예약
			String sql = "INSERT INTO booking values(null, ?, null, ?, null, null, null, now(), 1, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MainMenu.member.getMember_no());
			pstmt.setInt(2, flightBookingDTO.getDepartureFlight().getFlightNo());
			pstmt.setInt(3, flightBookingDTO.getFlightPeoples());

			departureResult = pstmt.executeUpdate();

			//복귀 항공기 예약
			sql = "INSERT INTO booking values(null, ?, null, ?, null, null, null, now(), 1, ?)";
			
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, MainMenu.member.getMember_no());
			pstmt2.setInt(2, flightBookingDTO.getReturnFlight().getFlightNo());
			pstmt2.setInt(3, flightBookingDTO.getFlightPeoples());
			
			returnResult = pstmt2.executeUpdate();
			
			if(departureResult == 1 && returnResult == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(pstmt2);
		}
		
		return result;
	}
	
}

package com.uni.flight.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.flight.model.dto.FlightBookingDTO;
import com.uni.flight.model.dto.FlightDTO;
import com.uni.main.view.MainMenu;
import com.uni.member.model.dto.Member;

public class FlightDAO {
	private Member member = MainMenu.member;

	public ArrayList<FlightDTO> selectFlightDepartureList(Connection conn, FlightBookingDTO flightBookingDTO) {
		ArrayList<FlightDTO> list = new ArrayList<FlightDTO>();
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
//		flight_no
//		air_no
//		flight_company
//		flight_departure
//		flight_airport_departure
//		flight_airport_return
//		flight_time
//		flight_price
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
		}
		
		return list;
	}
	
}

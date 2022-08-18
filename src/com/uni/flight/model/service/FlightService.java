package com.uni.flight.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.uni.flight.model.dao.FlightDAO;
import com.uni.flight.model.dto.FlightBookingDTO;
import com.uni.flight.model.dto.FlightDTO;

import static com.uni.common.JDBCTemplate.*;

public class FlightService {
	
	private FlightDAO flightDAO = new FlightDAO();

	public ArrayList<FlightDTO> selectFlightDepartureList(FlightBookingDTO flightBookingDTO) {
		Connection conn = getConnection();
		ArrayList<FlightDTO> list = flightDAO.selectFlightDepartureList(conn, flightBookingDTO);
		
		return list;
	}
	
}

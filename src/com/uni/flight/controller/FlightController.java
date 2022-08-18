package com.uni.flight.controller;

import java.util.ArrayList;

import com.uni.flight.model.dto.FlightBookingDTO;
import com.uni.flight.model.dto.FlightDTO;
import com.uni.flight.model.service.FlightService;

public class FlightController {
	FlightService flightService = new FlightService();

	public ArrayList<FlightDTO> getDepartureFlightList(FlightBookingDTO flightBookingDTO) {
		ArrayList<FlightDTO> list = flightService.selectFlightDepartureList(flightBookingDTO);
		
		return list;
	}
	
}

package com.uni.flight.model.dto;

public class FlightBookingDTO {
	private String flightDeparture;//출발일자
	private int travelPeriod;//여행기간
	private String flightCompany;//항공사명
	private String flightAirport;//출발공항
	private FlightDTO departureFlight = null;//출발항공기정보
	private FlightDTO returnFlight = null;//복귀항공기정보
	private int flightPeoples;//인원수
	
	public FlightBookingDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "[출발일자=" + flightDeparture + ", 여행기간=" + travelPeriod + ", 항공사명=" + flightCompany
				+ ", 출발공항=" + flightAirport + ", 출발항공기=" + departureFlight + ", 복귀항공기="
				+ returnFlight + ", 인원수=" + flightPeoples + "]";
	}

	public String getFlightDeparture() {
		return flightDeparture;
	}

	public void setFlightDeparture(String flightDeparture) {
		this.flightDeparture = flightDeparture;
	}

	public int getTravelPeriod() {
		return travelPeriod;
	}

	public void setTravelPeriod(int travelPeriod) {
		this.travelPeriod = travelPeriod;
	}

	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}

	public String getFlightAirport() {
		return flightAirport;
	}

	public void setFlightAirport(String flightAirport) {
		this.flightAirport = flightAirport;
	}

	public FlightDTO getDepartureFlight() {
		return departureFlight;
	}

	public void setDepartureFlight(FlightDTO departureFlight) {
		this.departureFlight = departureFlight;
	}

	public FlightDTO getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(FlightDTO returnFlight) {
		this.returnFlight = returnFlight;
	}

	public int getFlightPeoples() {
		return flightPeoples;
	}

	public void setFlightPeoples(int flightPeoples) {
		this.flightPeoples = flightPeoples;
	}

	
}



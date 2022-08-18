package com.uni.flight.model.dto;

public class FlightDTO {
	private int flightNo;
	private int airNo;
	private String flightCompany;
	private String flightDeparture;
	private String flightAirportDeparture;
	private String flightAirportReturn;
	private String flightTime;
	private int flightPrice;
	
	public FlightDTO() {
		// TODO Auto-generated constructor stub
	}

	public FlightDTO(int flightNo, int airNo, String flightCompany, String flightDeparture,
			String flightAirportDeparture, String flightAirportReturn, String flightTime, int flightPrice) {
		super();
		this.flightNo = flightNo;
		this.airNo = airNo;
		this.flightCompany = flightCompany;
		this.flightDeparture = flightDeparture;
		this.flightAirportDeparture = flightAirportDeparture;
		this.flightAirportReturn = flightAirportReturn;
		this.flightTime = flightTime;
		this.flightPrice = flightPrice;
	}

	@Override
	public String toString() {
		return "FlightDTO [항공기관리번호=" + flightNo + ", 항공사명=" + flightCompany + ", 항공기번호=" + airNo + ", 출발일자="
				+ flightDeparture + ", 출발공항=" + flightAirportDeparture + ", 도착공항=" + flightAirportReturn + ", 출발시간=" + flightTime + ", flightPrice="
				+ flightPrice + "]";
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public int getAirNo() {
		return airNo;
	}

	public void setAirNo(int airNo) {
		this.airNo = airNo;
	}

	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}

	public String getFlightDeparture() {
		return flightDeparture;
	}

	public void setFlightDeparture(String flightDeparture) {
		this.flightDeparture = flightDeparture;
	}

	public String getFlightAirportDeparture() {
		return flightAirportDeparture;
	}

	public void setFlightAirportDeparture(String flightAirportDeparture) {
		this.flightAirportDeparture = flightAirportDeparture;
	}

	public String getFlightAirportReturn() {
		return flightAirportReturn;
	}

	public void setFlightAirportReturn(String flightAirportReturn) {
		this.flightAirportReturn = flightAirportReturn;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public int getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(int flightPrice) {
		this.flightPrice = flightPrice;
	}
	
	
}

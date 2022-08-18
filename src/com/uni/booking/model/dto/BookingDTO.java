package com.uni.booking.model.dto;

import java.io.Serializable;

import com.uni.flight.model.dto.FlightDTO;
import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.spot.model.dto.SpotDto;
import com.uni.stay.model.dto.Stay;

/**
 * <pre>
 * Class : BookingDTO
 * Comment : BookingDTO
 * History
 * 2022/08/16 (박준성) 처음 작성함
 * </pre>
 * @author 박준성
 * @version 1.0.0
 * */
public class BookingDTO implements Serializable{
	private static final long serialVersionUID = -5291363112892509989L;
	
	private int bookingNo;
	private int memberNo;
	private int payNo;
	private int flightNo;
	private int spotNo;
	private int rentcarNo;
	private int stayNo;
	private String bookingDay;
	private int bookingSection;
	private int bookingPeople;
	private FlightDTO flight;
	private SpotDto spot;
	private RentCarDto rentcar;
	private Stay stay;
	
	public BookingDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookingDTO(int bookingNo, int memberNo, int payNo, int flightNo, int spotNo, int rentcarNo, int stayNo,
			String bookingDay, int bookingSection, int bookingPeople, FlightDTO flight, SpotDto spot,
			RentCarDto rentcar, Stay stay) {
		super();
		this.bookingNo = bookingNo;
		this.memberNo = memberNo;
		this.payNo = payNo;
		this.flightNo = flightNo;
		this.spotNo = spotNo;
		this.rentcarNo = rentcarNo;
		this.stayNo = stayNo;
		this.bookingDay = bookingDay;
		this.bookingSection = bookingSection;
		this.bookingPeople = bookingPeople;
		this.flight = flight;
		this.spot = spot;
		this.rentcar = rentcar;
		this.stay = stay;
	}

	@Override
	public String toString() {
		return "BookingDTO [bookingNo=" + bookingNo + ", memberNo=" + memberNo + ", payNo=" + payNo + ", flightNo="
				+ flightNo + ", spotNo=" + spotNo + ", rentcarNo=" + rentcarNo + ", stayNo=" + stayNo + ", bookingDay="
				+ bookingDay + ", bookingSection=" + bookingSection + ", bookingPeople=" + bookingPeople + ", flight="
				+ flight + ", spot=" + spot + ", rentcar=" + rentcar + ", stay=" + stay + "]";
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public int getSpotNo() {
		return spotNo;
	}

	public void setSpotNo(int spotNo) {
		this.spotNo = spotNo;
	}

	public int getRentcarNo() {
		return rentcarNo;
	}

	public void setRentcarNo(int rentcarNo) {
		this.rentcarNo = rentcarNo;
	}

	public int getStayNo() {
		return stayNo;
	}

	public void setStayNo(int stayNo) {
		this.stayNo = stayNo;
	}

	public String getBookingDay() {
		return bookingDay;
	}

	public void setBookingDay(String bookingDay) {
		this.bookingDay = bookingDay;
	}

	public int getBookingSection() {
		return bookingSection;
	}

	public void setBookingSection(int bookingSection) {
		this.bookingSection = bookingSection;
	}

	public int getBookingPeople() {
		return bookingPeople;
	}

	public void setBookingPeople(int bookingPeople) {
		this.bookingPeople = bookingPeople;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public SpotDto getSpot() {
		return spot;
	}

	public void setSpot(SpotDto spot) {
		this.spot = spot;
	}

	public RentCarDto getRentcar() {
		return rentcar;
	}

	public void setRentcar(RentCarDto rentcar) {
		this.rentcar = rentcar;
	}

	public Stay getStay() {
		return stay;
	}

	public void setStay(Stay stay) {
		this.stay = stay;
	}
		
}

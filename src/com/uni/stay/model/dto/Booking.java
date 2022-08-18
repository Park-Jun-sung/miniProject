package com.uni.stay.model.dto;

import java.util.Date;

/**
 * <pre>
 * Class : Booking
 * Comment : 예약 테이블에 예약데이터를 삽입하기위해 필요한 DTO
 * History
 * 2022/08/18 (김성환) 처음 작성함
 * </pre>
 * @author 김성환
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class Booking {

	private int bookingNo;
	private int memberNo;
	private Date bookingDay;
	private int bookingSection;

	private int stayNo;
	private int stayCode;
	private String stayArea;
	private String stayName;
	private Date stayDay;
	private int price;

	public Booking() {
	}

	public Booking(int bookingNo, int memberNo, Date bookingDay, int bookingSection, int stayNo,
			int stayCode, String stayArea, String stayName, Date stayDay, int price) {
		super();
		this.bookingNo = bookingNo;
		this.memberNo = memberNo;
		this.bookingDay = bookingDay;
		this.bookingSection = bookingSection;
		this.stayNo = stayNo;
		this.stayCode = stayCode;
		this.stayArea = stayArea;
		this.stayName = stayName;
		this.stayDay = stayDay;
		this.price = price;
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

	public Date getBookingDay() {
		return bookingDay;
	}

	public void setBookingDay(Date bookingDay) {
		this.bookingDay = bookingDay;
	}

	public int getBookingSection() {
		return bookingSection;
	}

	public void setBookingSection(int bookingSection) {
		this.bookingSection = bookingSection;
	}

	public int getStayNo() {
		return stayNo;
	}

	public void setStayNo(int stayNo) {
		this.stayNo = stayNo;
	}

	public int getStayCode() {
		return stayCode;
	}

	public void setStayCode(int stayCode) {
		this.stayCode = stayCode;
	}

	public String getStayArea() {
		return stayArea;
	}

	public void setStayArea(String stayArea) {
		this.stayArea = stayArea;
	}

	public String getStayName() {
		return stayName;
	}

	public void setStayName(String stayName) {
		this.stayName = stayName;
	}

	public void setStayNo(String stayNo) {
		this.stayNo = Integer.parseInt(stayNo);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}

	public Date getStayDay() {
		return stayDay;
	}

	public void setStayDay(Date stayDay) {
		this.stayDay = stayDay;
	}
	
	
	
}

package com.uni.stay.model.dto;

import java.util.Date;

/**
 * <pre>
 * Class : BookingStay
 * Comment : 예약정보를 입력받기위한 DTO
 * History
 * 2022/08/16 (김성환) 처음 작성함
 * </pre>
 * @author 김성환
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class BookingStay {

	private int stayNo;
	private int stayCode;
	private String stayArea;
	private String stayName;
	private Date stayDay;
//	private int price;
	
	public BookingStay() {
	}

	public BookingStay(int stayNo, int stayCode, String stayArea, String stayName, Date stayDay) {
		super();
		this.stayNo = stayNo;
		this.stayCode = stayCode;
		this.stayArea = stayArea;
		this.stayName = stayName;
		this.stayDay = stayDay;
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

	public Date getStayDay() {
		return stayDay;
	}

	public void setStayDay(Date stayDay) {
		this.stayDay = stayDay;
	}

	
	
}

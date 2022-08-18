package com.uni.stay.model.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * <pre>
 * Class : Stay
 * Comment : DB stay table 에서 데이터를 가져오기위한 DTO
 * History
 * 2022/08/15 (김성환) 처음 작성함
 * </pre>
 * @author 김성환
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class Stay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8931147936417746277L;
	private int stayNo;
	private int stayCode;
	private String stayArea;
	private String stayName;
	private Date stayDay;
	private int price;
	
	public Stay() {
	}

	public Stay(int stayNo, int stayCode, String stayArea, String stayName, Date stayDay, int price) {
		super();
		this.stayNo = stayNo;
		this.stayCode = stayCode;
		this.stayArea = stayArea;
		this.stayName = stayName;
		this.stayDay = stayDay;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return stayNo + ", " + stayCode + ", " + stayArea + ", " + stayName
				+ ", " + stayDay + ", " + price;
	}

	
	
	
}

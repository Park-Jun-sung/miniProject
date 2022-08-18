package com.uni.spot.model.dto;

public class SpotDto {

	
	private static final long serialVersionUID = -8931147936417746277L;
	private int spotNo;
	private int spotCode;
	private String spotName;
	private String spotArea;
	private String spotTime;
	private int price;
	
	public SpotDto() {
		super();
	}

	public SpotDto(int spotNo, int spotCode, String spotName, String spotArea, String spotTime, int price) {
		super();
		this.spotNo = spotNo;
		this.spotCode = spotCode;
		this.spotName = spotName;
		this.spotArea = spotArea;
		this.spotTime = spotTime;
		this.price = price;
	}


	public int getSpotNo() {
		return spotNo;
	}


	public void setSpotNo(int spotNo) {
		this.spotNo = spotNo;
	}


	public int getSpotCode() {
		return spotCode;
	}


	public void setSpotCode(int spotCode) {
		this.spotCode = spotCode;
	}


	public String getSpotName() {
		return spotName;
	}


	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}


	public String getSpotArea() {
		return spotArea;
	}


	public void setSpotArea(String spotArea) {
		this.spotArea = spotArea;
	}


	public String getSpotTime() {
		return spotTime;
	}


	public void setSpotTime(String spotTime) {
		this.spotTime = spotTime;
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
	
	
	
	
	
	
	
}

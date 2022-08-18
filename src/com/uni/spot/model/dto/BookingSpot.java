package com.uni.spot.model.dto;

public class BookingSpot {
	
	private int spotCode; // 
	private String spotArea;
	private String spotName;
	private String spotTime;
	private String Price;
	
	
	
	public BookingSpot() {
	}



	public BookingSpot(int spotCode, String spotArea, String spotName, String spotTime, String spotPrice) {
		super();
		this.spotCode = spotCode;
		this.spotArea = spotArea;
		this.spotName = spotName;
		this.spotTime = spotTime;
		this.Price = Price;
	}


	
	

	public int getSpotCode() {
		return spotCode;
	}



	public void setSpotCode(int spotCode) {
		this.spotCode = spotCode;
	}



	public String getSpotArea() {
		return spotArea;
	}



	public void setSpotArea(String spotArea) {
		this.spotArea = spotArea;
	}



	public String getSpotName() {
		return spotName;
	}



	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}



	public String getSpotTime() {
		return spotTime;
	}



	public void setSpotTime(String spotTime) {
		this.spotTime = spotTime;
	}



	public String getSpotPrice() {
		return Price;
	}



	public void setSpotPrice(String spotPrice) {
		this.Price = spotPrice;
	}
	

	
	





	



}

package com.uni.RentCar.member.model.Car_Classification;

import java.util.Date;

import com.uni.RentCar.member.model.Car;

public class Car_Classification extends Car {
	
	private String rentcar_section;
	private String rentcar_fuel;
	private int rentcar_limit;
	private String rentcar_time;
	
	
	public Car_Classification() {
		
	}
	
	public Car_Classification(int rentcar_no, String car_no, String rentcar_model, Date rentcar_date,
			Date rentcar_datetime, Date rentcar_enddate, Date rentcar_endtime, Date rentcar_renttime, int rentcar_price,
			String rentcar_section, String rentcar_fuel, int rentcar_limit, String rentcar_time) {
		
		super(rentcar_no, car_no, rentcar_model, rentcar_date, rentcar_datetime, rentcar_enddate, rentcar_endtime,
				rentcar_renttime, rentcar_price);
		this.rentcar_section = rentcar_section;
		this.rentcar_fuel = rentcar_fuel;
		this.rentcar_limit = rentcar_limit;
		this.rentcar_time = rentcar_time;
	}


	public String getRentcar_section() {
		return rentcar_section;
	}


	public void setRentcar_section(String rentcar_section) {
		this.rentcar_section = rentcar_section;
	}


	public String getRentcar_fuel() {
		return rentcar_fuel;
	}


	public void setRentcar_fuel(String rentcar_fuel) {
		this.rentcar_fuel = rentcar_fuel;
	}


	public int getRentcar_limit() {
		return rentcar_limit;
	}


	public void setRentcar_limit(int rentcar_limit) {
		this.rentcar_limit = rentcar_limit;
	}


	public String getRentcar_time() {
		return rentcar_time;
	}


	public void setRentcar_time(String rentcar_time) {
		this.rentcar_time = rentcar_time;
	}
	
}

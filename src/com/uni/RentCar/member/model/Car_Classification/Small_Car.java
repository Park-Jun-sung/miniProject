package com.uni.RentCar.member.model.Car_Classification;

import java.util.Date;

public class Small_Car extends Car_Classification {
	
	
	
	public Small_Car() {
		
	}
	
	public Small_Car(int rentcar_no, String car_no, String rentcar_model, Date rentcar_date, Date rentcar_datetime,
			Date rentcar_enddate, Date rentcar_endtime, Date rentcar_renttime, int rentcar_price,
			String rentcar_section, String rentcar_fuel, int rentcar_limit, String rentcar_time) {
		
		super(rentcar_no, car_no, rentcar_model, rentcar_date, rentcar_datetime, rentcar_enddate, rentcar_endtime,
				rentcar_renttime, rentcar_price, rentcar_section, rentcar_fuel, rentcar_limit, rentcar_time);
		// TODO Auto-generated constructor stub
	}
		
	

	@Override
	public String getRentcar_section() {
		// TODO Auto-generated method stub
		return super.getRentcar_section();
	}

	@Override
	public void setRentcar_section(String rentcar_section) {
		// TODO Auto-generated method stub
		super.setRentcar_section(rentcar_section);
	}

	@Override
	public String getRentcar_fuel() {
		// TODO Auto-generated method stub
		return super.getRentcar_fuel();
	}

	@Override
	public void setRentcar_fuel(String rentcar_fuel) {
		// TODO Auto-generated method stub
		super.setRentcar_fuel(rentcar_fuel);
	}

	@Override
	public int getRentcar_limit() {
		// TODO Auto-generated method stub
		return super.getRentcar_limit();
	}

	@Override
	public void setRentcar_limit(int rentcar_limit) {
		// TODO Auto-generated method stub
		super.setRentcar_limit(rentcar_limit);
	}

	@Override
	public String getRentcar_time() {
		// TODO Auto-generated method stub
		return super.getRentcar_time();
	}

	@Override
	public void setRentcar_time(String rentcar_time) {
		// TODO Auto-generated method stub
		super.setRentcar_time(rentcar_time);
	}

	
	
}

package com.uni.rentCar.model.dto;

import java.io.Serializable;
import java.util.Date;

public class RentCarDto implements Serializable {

	private static final long serialVersionUID = 6346615596757676147L;
	
	private int rentcar_no;
	private String car_no;
	private String rentcar_model;
	private Date rentcar_date;
	private Date rentcar_datetime;
	private Date rentcar_enddate;
	private Date rentcar_endtime;
	private int rentcar_renttime;
	private int rentcar_price;
	private String rentcar_section;
	private String rentcar_fuel;
	private int rentcar_limit;
	private String rentcar_time;
	
	public RentCarDto() {
		
		
	}
	
	public RentCarDto(int rentcar_no, String car_no, String rentcar_model, Date rentcar_date, Date rentcar_datetime,
			Date rentcar_enddate, Date rentcar_endtime, int rentcar_renttime, int rentcar_price,
			String rentcar_section, String rentcar_fuel, int rentcar_limit, String rentcar_time) {
		super();
		this.rentcar_no = rentcar_no;
		this.car_no = car_no;
		this.rentcar_model = rentcar_model;
		this.rentcar_date = rentcar_date;
		this.rentcar_datetime = rentcar_datetime;
		this.rentcar_enddate = rentcar_enddate;
		this.rentcar_endtime = rentcar_endtime;
		this.rentcar_renttime = rentcar_renttime;
		this.rentcar_price = rentcar_price;
		this.rentcar_section = rentcar_section;
		this.rentcar_fuel = rentcar_fuel;
		this.rentcar_limit = rentcar_limit;
		this.rentcar_time = rentcar_time;
	}

	public int getRentcar_no() {
		return rentcar_no;
	}

	public void setRentcar_no(int rentcar_no) {
		this.rentcar_no = rentcar_no;
	}

	public String getCar_no() {
		return car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	public String getRentcar_model() {
		return rentcar_model;
	}

	public void setRentcar_model(String rentcar_model) {
		this.rentcar_model = rentcar_model;
	}

	public Date getRentcar_date() {
		return rentcar_date;
	}

	public void setRentcar_date(Date rentcar_date) {
		this.rentcar_date = rentcar_date;
	}

	public Date getRentcar_datetime() {
		return rentcar_datetime;
	}

	public void setRentcar_datetime(Date rentcar_datetime) {
		this.rentcar_datetime = rentcar_datetime;
	}

	public Date getRentcar_enddate() {
		return rentcar_enddate;
	}

	public void setRentcar_enddate(Date rentcar_enddate) {
		this.rentcar_enddate = rentcar_enddate;
	}

	public Date getRentcar_endtime() {
		return rentcar_endtime;
	}

	public void setRentcar_endtime(Date rentcar_endtime) {
		this.rentcar_endtime = rentcar_endtime;
	}

	public int getRentcar_renttime() {
		return rentcar_renttime;
	}

	public void setRentcar_renttime(int rentcar_renttime) {
		this.rentcar_renttime = rentcar_renttime;
	}

	public int getRentcar_price() {
		return rentcar_price;
	}

	public void setRentcar_price(int rentcar_price) {
		this.rentcar_price = rentcar_price;
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

	@Override
	public String toString() {
		
//		String str1 =  rentcar_no + "    " + car_no + "   " + rentcar_model;
//		
//		return  str1 + "       " + rentcar_date + "    " + rentcar_datetime + "     "
//		+ rentcar_enddate + "       " + rentcar_endtime + "      " + rentcar_renttime
//		+ "        " + rentcar_price + "    " + rentcar_section + "     " + rentcar_fuel + "      " + rentcar_limit + "       " + rentcar_time;
		
		return  rentcar_no + "    " + car_no + "   " + rentcar_model + "     " + rentcar_date + "    " + rentcar_datetime + "     "
				+ rentcar_enddate + "       " + rentcar_endtime + "      " + rentcar_renttime
				+ "        " + rentcar_price + "    " + rentcar_section + "     " + rentcar_fuel + "      " + rentcar_limit + "       " + rentcar_time;
	}
	
	
	
	
}

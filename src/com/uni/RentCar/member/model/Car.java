package com.uni.RentCar.member.model;

import java.util.Date;

public class Car {

	private int rentcar_no;
	private String car_no;
	private String rentcar_model;
	private Date rentcar_date;
	private Date rentcar_datetime;
	private Date rentcar_enddate;
	private Date rentcar_endtime;
	private Date rentcar_renttime;
	private int rentcar_price;
	
	
	public Car() {
		
	}
	
	public Car(int rentcar_no, String car_no, String rentcar_model, Date rentcar_date, Date rentcar_datetime,
			Date rentcar_enddate, Date rentcar_endtime, Date rentcar_renttime, int rentcar_price) {
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


	public Date getRentcar_renttime() {
		return rentcar_renttime;
	}


	public void setRentcar_renttime(Date rentcar_renttime) {
		this.rentcar_renttime = rentcar_renttime;
	}


	public int getRentcar_price() {
		return rentcar_price;
	}


	public void setRentcar_price(int rentcar_price) {
		this.rentcar_price = rentcar_price;
	}
	
}

package com.uni.RentCar.member.controller;

import com.uni.RentCar.member.model.Car_Classification.Mid_Car;
import com.uni.RentCar.member.model.Car_Classification.SUV;
import com.uni.RentCar.member.model.Car_Classification.Small_Car;

public class Car_Controller {

	
	
	
	public void Car_SelectTime(/*인수 일자, 인수 시간, 반납 일자, 반납 시간 */) {
		
		// Car_SelectTime에 대한 예약완료가 됐을 경우////
		// 차 선택으로 넘어가게 된다.
		
	}
	
	
	
	public void Car_Select(int select) {
		
		/*
		 *	1 : 소형 
		 *  2 : 중형
		 *  3 : SUV 
		 */
		
		
		if (select == 1) {
			Small_Car sm = new Small_Car();
			
			
			
		} else if (select == 2) {
			Mid_Car mi = new Mid_Car();
			
			
			
		} else if (select == 3) {
			SUV su = new SUV();
			
			
		}
		
	}
	
}

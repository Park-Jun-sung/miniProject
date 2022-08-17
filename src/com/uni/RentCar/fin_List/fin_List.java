package com.uni.rentCar.fin_List;

import java.util.ArrayList;

import com.uni.rentCar.model.dto.RentCarDto;

public class fin_List {

	
	public ArrayList<RentCarDto> book_date(ArrayList<RentCarDto> book) {
		
		 ArrayList<RentCarDto> book_date_list = new ArrayList<RentCarDto>(); 
		
		 
		 // 날짜로 조건을 받고 그 조건에 의해서 나온 값을 다시 book_date_list에 넣는다.
		 // 나중에 다시 예약 조건을 확인하기 위한 확인용
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_date_list.set(i, book.get(i));
		 }
		 
		
		return book_date_list;
	}
	
	
	public ArrayList<RentCarDto> book_time(ArrayList<RentCarDto> book) {
		
		ArrayList<RentCarDto> book_time_list = new ArrayList<RentCarDto>();
		
		 // 시간으로 조건을 받고 그 조건에 의해서 나온 값을 다시 book_time_list에 넣는다.
		 // 나중에 다시 예약 조건을 확인하기 위한 확인용
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_time_list.set(i, book.get(i));
		 }
		
		
		return book_time_list;
	}
	
	
	public ArrayList<RentCarDto> book_Carmodel(ArrayList<RentCarDto> book) {
		
		ArrayList<RentCarDto> book_car_list = new ArrayList<RentCarDto>();
		
		 // 차종으로 조건을 받고 그 조건에 의해서 나온 값을 다시 book_car_list에 넣는다.
		 // 나중에 다시 예약 조건을 확인하기 위한 확인용
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_car_list.set(i, book.get(i));
		 }
		
		
		return book_car_list;
	}
	
	public ArrayList<RentCarDto> book_fin() {
		
		ArrayList<RentCarDto> book_fin_list = new ArrayList<RentCarDto>();
		
		
		return book_fin_list;
	}
	
}

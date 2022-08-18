package com.uni.rentCar.fin_List;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.rentCar.view.RentCarMenu;

	 

public class fin_List {

	public ArrayList<RentCarDto> book_date(ArrayList<RentCarDto> book) {
		
		 ArrayList<RentCarDto> book_date_list = new ArrayList<RentCarDto>(); 
		
		 
		 // 날짜로 조건을 받고 그 조건에 의해서 나온 값을 다시 book_date_list에 넣는다.
		 // 나중에 다시 예약 조건을 확인하기 위한 확인용
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_date_list.add(i, book.get(i));
		 }
		 
		
		return book_date_list;
	}
	
	
	public ArrayList<RentCarDto> book_time(ArrayList<RentCarDto> book, String Select_time) {
		
		ArrayList<RentCarDto> book_time_list = new ArrayList<RentCarDto>(book.size());
		
	 
		 String select_time_add = Select_time + ":00";
			
		 int count = 0;
		 
		 for (int i = 0; i < book.size(); ++i) {
			 
			 Date rent_time = book.get(i).getRentcar_datetime();
			 
			 SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
			 
			 String Str_format_renttime = dateformat.format(rent_time);
			 
			 
			 if (Str_format_renttime.compareTo(select_time_add) >= 0) {
				 
				 book_time_list.add(count, book.get(i));
				 count++;
			 }
			 
//			 if (Str_format_renttime.equals(select_time_add)) {
//				 
//				 book_time_list.add(count, book.get(i));
//				 count++;
//			 }
		 }
		
		return book_time_list;
	}
	
	
	public ArrayList<RentCarDto> book_Carsection(ArrayList<RentCarDto> book, String carselectsection) {
		
		ArrayList<RentCarDto> book_car_list = new ArrayList<RentCarDto>(book.size());
		
		 // 차종으로 조건을 받고 그 조건에 의해서 나온 값을 다시 book_car_list에 넣는다.
		 // 나중에 다시 예약 조건을 확인하기 위한 확인용
		 String car_section;
		 int count = 0;
		 
		 for (int i = 0; i < book.size(); ++i) {
			 
			 car_section = book.get(i).getRentcar_section();
			 
			 if (car_section.equals(carselectsection)) {
				 
				 if (book.get(i).getRentcar_section() == null) {
					 
					 continue;
				 }
				 
				 book_car_list.add(count, book.get(i));
				 count++;
			 }
			 
			 
			 
		 }
		 
		 
		 System.out.println("마지막 예약 리스트");
		 // book의 처음 리스트 값에 모든값을 대입 
		 
		 for (int i = 0; i < 1; ++i) {
			 
			 System.out.println(book.get(i).getCar_no() + " " + 
					 	        book.get(i).getRentcar_date() + " " + 
					 	        book.get(i).getRentcar_section());
		 }
		
		
		 book_fin(book_car_list);
		 
		return book_car_list;
	}

	
	// 마지막 한개의 예약 리스트
	
	public RentCarDto book_fin(ArrayList<RentCarDto> book) {
		
		RentCarMenu menu = new RentCarMenu();
		
		menu.dto.setRentcar_no(book.get(0).getRentcar_no());
		menu.dto.setCar_no(book.get(0).getCar_no());
		menu.dto.setRentcar_model(book.get(0).getRentcar_model());
		menu.dto.setRentcar_date(book.get(0).getRentcar_date());
		menu.dto.setRentcar_datetime(book.get(0).getRentcar_datetime());
		menu.dto.setRentcar_enddate(book.get(0).getRentcar_enddate());
		menu.dto.setRentcar_endtime(book.get(0).getRentcar_endtime());
		menu.dto.setRentcar_renttime(book.get(0).getRentcar_renttime());
		menu.dto.setRentcar_price(book.get(0).getRentcar_price());
		menu.dto.setRentcar_section(book.get(0).getRentcar_section());
		menu.dto.setRentcar_fuel(book.get(0).getRentcar_fuel());
		menu.dto.setRentcar_limit(book.get(0).getRentcar_limit());
		menu.dto.setRentcar_time(book.get(0).getRentcar_time());
		
		
		
		System.out.println(menu.dto.getCar_no());
		
		return menu.dto;
	}
	
}
package com.uni.rentCar.fin_List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.rentCar.view.RentCarMenu;

/**
 * <pre>
 * Class : fin_List
 * Comment : 예약이 끝난 렌트카 리스트를 뽑아온다.
 * History
 * 2022/08/18 정인섭 처음 작성함
 * </pre>
 * 
 */
public class fin_List {
	
	/**
	 * @param ArrayList<RentCarDto> book ArrayList에 RentCrDto 넣을 매개변수
	 * @return List를 다른 book_date_list 따로 값을 대입하고 리턴
	 */
	public ArrayList<RentCarDto> book_date(ArrayList<RentCarDto> book) {
		 ArrayList<RentCarDto> book_date_list = new ArrayList<RentCarDto>();  
		 
		 // 날짜로 조건을 받고 그 조건에 의해서 나온 값을 다시 book_date_list에 넣는다.
		 // 나중에 다시 예약 조건을 확인하기 위한 확인용
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_date_list.add(i, book.get(i));
		 }
		return book_date_list;
	}
	
	/**
	 * @param ArrayList<RentCarDto> book ArrayList에 RentCrDto 넣을 매개변수
	 * @param String Select_time DB에서 받아올 데이트 형식을 맞추고, 시간을 입력 받음
	 * @return book_time_list 시간을 입력받고 db에 해당하는 데이터를 호출
	 */
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
		 }
		
		return book_time_list;
	}
	
	
	/**
	 * @param ArrayList<RentCarDto> book RentCrDto 넣을 매개변수
	 * @param String carselectsection 차종을 넣은 String 변수
	 * @return book_car_list 마지막 차종까지 입력하면 데이터의 한행이 나옴 
	 */
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
		 
		 book_fin(book_car_list);
		 
		return book_car_list;
	}

	
	// 마지막 한개의 예약 리스트
	
	/**
	 * @param ArrayList<RentCarDto> book RentCrDto 넣을 매개변수
	 * @return RentCarMenu.dto 전역변수로 하나의 dto를 만들고 최종 데이터를 설정
	 */
	public RentCarDto book_fin(ArrayList<RentCarDto> book) {
		
		RentCarMenu.dto.setRentcar_no(book.get(0).getRentcar_no());
		RentCarMenu.dto.setCar_no(book.get(0).getCar_no());
		RentCarMenu.dto.setRentcar_model(book.get(0).getRentcar_model());
		RentCarMenu.dto.setRentcar_date(book.get(0).getRentcar_date());
		RentCarMenu.dto.setRentcar_datetime(book.get(0).getRentcar_datetime());
		RentCarMenu.dto.setRentcar_enddate(book.get(0).getRentcar_enddate());
		RentCarMenu.dto.setRentcar_endtime(book.get(0).getRentcar_endtime());
		RentCarMenu.dto.setRentcar_renttime(book.get(0).getRentcar_renttime());
		RentCarMenu.dto.setRentcar_price(book.get(0).getRentcar_price());
		RentCarMenu.dto.setRentcar_section(book.get(0).getRentcar_section());
		RentCarMenu.dto.setRentcar_fuel(book.get(0).getRentcar_fuel());
		RentCarMenu.dto.setRentcar_limit(book.get(0).getRentcar_limit());
		RentCarMenu.dto.setRentcar_time(book.get(0).getRentcar_time());
		
		
		return RentCarMenu.dto;
	}
	
}
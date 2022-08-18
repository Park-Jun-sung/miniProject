package com.uni.rentCar.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.uni.rentCar.fin_List.fin_List;
import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.rentCar.model.service.RentCarService;
import com.uni.rentCar.view.RentCarMenu;
import com.uni.utile.StrDate;
import com.uni.utile.StrTime;


/**
 * <pre>
 * Class : RentCarController
 * Comment : RentCarController 서비스에 데이터 전달 
 * History
 * 2022/08/18 정인섭 처음 작성함
 * </pre>
 * @author 정인섭
 * @version 1.0.0
 * */
public class RentCarController {
	
	// 렌트카 서비스의 객체 생성
	private RentCarService RentcarService = new RentCarService();
	
	// Menu에 대한 스태틱 객체 설정
	public static RentCarMenu Carmenu = new RentCarMenu();
	
	// fin_List에 대한 class 전역 객체 생성
	fin_List List_book_date = new fin_List();
	
	// Final_appointment_Rentcar_list에 대한 100개의 공간을 만든다.
	int max_size = 100;
	public ArrayList<RentCarDto> Final_appointment_Rentcar_list = new ArrayList<RentCarDto>(max_size);
	
	
	/**
		DB에 전체 렌트카 정보를 조회
	 */
	public void selectAll() {
		
		RentCarMenu Carmenu = new RentCarMenu();
		
		ArrayList<RentCarDto> list = RentcarService.selectAll();
		
		if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			Carmenu.displayRentCarList(list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}
	
	
	/**
	 * 마지막으로 조회가 된 booking 테이블에 데이터를 설정함 
	 */
	public void InsertReserTable() {
		
		System.out.println("예약 하시겠습니까? (y/n)");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.nextLine();
		
		Carmenu = new RentCarMenu();
		
		if (str.equals("y") || str.equals("Y")) {
			
			System.out.println(RentCarMenu.dto.getRentcar_no());
			
			int result_reser = RentcarService.InsertReserTable(RentCarMenu.dto);
			
			if(result_reser > 0 ) {	
				new RentCarMenu().displaySuccess("렌트카 예약 성공");
			}else {
				new RentCarMenu().displayError("렌트카 예약 실패");
			}
			
			
		} else {
			
			System.out.println("예약이 취소되었습니다.");
		}
		
	}
	
	
	 
	/**
	 * 예약이 된 자동차를 여기서 메뉴 객체를 생성해서 메뉴에 출력하기 위해 던져줌 
	 */
	public void ReservationCar() {
		
		Carmenu = new RentCarMenu();
		
		Carmenu.displayfinRentCar(List_book_date.book_fin(Final_appointment_Rentcar_list));
		
	}
	
	
	// 반납 날짜는 나중에 기입 
	public void UpdatereturnDate() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("반납 날짜를 입력하세요 : (예 20220809)");
		String str_date_sel = sc.next();
		sc.nextLine();
		
		System.out.println("반납 시간 입력하세요 : ((예 8AM -> 8, 2pm -> 14)");
		String str_sec_sel = sc.next();
		sc.nextLine();
		
		StrDate str_date = new StrDate();
		String Return_date = str_date.strDate(str_date_sel);
		
		StrTime str_sec = new StrTime();
		String Return_second = str_sec.str_time(str_sec_sel);
		
		int result = RentcarService.UpdatereturnDate(RentCarMenu.dto.getRentcar_no(), Return_date, Return_second);
		
		// 아 반납은 차가 결정 되고 나서 반납 날짜가 정해져야 업데이트를 할 수 있구나.
		// 렌트카가 하나가 나올테니깐 
		
		if(result > 0 ) {	
			new RentCarMenu().displaySuccess("렌트카 정보 수정 성공");
		}else {
			new RentCarMenu().displayError("렌트카 정보 수정 실패");
		}
		
	}
	
	
	
	
	/**
	 * 예약 날짜를 선택하기 위해 만든 메소드 
	 */
	public void selectDate() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("인수 날짜를 입력하세요 : (예 20220809)");
		String str = sc.next();
		sc.nextLine();
		
		StrDate str_date = new StrDate();
		
		// utile에서 만든 strDate를 사용해서 20220809 -> 2022-08-09로 변환
		String Selec_date = str_date.strDate(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectDate(Selec_date);
	
		
		// =============================================
		// 인수 날짜 조회를 한것을 다른 최종 리스트에 저장.
		
		Final_appointment_Rentcar_list = List_book_date.book_date(ca_list);	
		
		// =============================================
		
		// 날짜를 조회한 테이블을 출력 함 
		// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
		if(!ca_list.isEmpty()) {
			Carmenu.displayRentCarList(ca_list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
	}
	
	
	/**
     * 인수 시간을 설정하는 메소드 
	 */
	public void selectTime() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("인수 시간을 입력하세요 : (예 8AM -> 8, 2pm -> 14)");
		String str = sc.next();
		sc.nextLine();
		
		
		// utile에 만든 str_time에서 8을 입력하면 08:00로 변환
		StrTime str_time = new StrTime();
		String Selec_time = str_time.str_time(str);
		ArrayList<RentCarDto> ca_list = RentcarService.selectTime(Selec_time);
		
		
		
		// ============================================
		// 인수 날짜 조회한 리스트를 다시 인수 시간을 조회
		//
		if (Final_appointment_Rentcar_list != null) {
			
			Final_appointment_Rentcar_list = List_book_date.book_time(Final_appointment_Rentcar_list, Selec_time);
			
			if(!Final_appointment_Rentcar_list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
				Carmenu.displayRentCarList(Final_appointment_Rentcar_list);
			}else {
				Carmenu.displayError("해당되는 데이터가 없습니다.");
			}
		}
		// ============================================
		
		// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
		// db에 있는 시간에 모두 해당하는 데이터를 출력 
		if(!ca_list.isEmpty()) {
			Carmenu.displayRentCarList(ca_list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}



	
	/**
	 * 차종(소형, 중형, 대형, SUV)를 입력하는 메소드 
	 */
	public void selectCarSection() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("차 종을 선택하세요 (소형, 중형, SUV, 대형) : ");
		String str = sc.next();
		sc.nextLine();
		
		ArrayList<RentCarDto> list = RentcarService.selectsection(str);
		
		// =============================================
		// 인수 날짜,시간 조회를 한 리스트를 차종으로 다시 조회함  
		if (Final_appointment_Rentcar_list != null) {
			
			Final_appointment_Rentcar_list = List_book_date.book_Carsection(Final_appointment_Rentcar_list, str);
			
			// ######################## 최종 예약 객체 ####################
			// 최종 리스트를 출력함
			if(!Final_appointment_Rentcar_list.isEmpty()) {
				Carmenu.displayRentCarList(Final_appointment_Rentcar_list);
			}else {
				Carmenu.displayError("해당되는 데이터가 없습니다.");
			}
			
		}
		// =============================================
		
		// 날짜, 시간을 선택하지 않고 차종만 선택했을때의 데이터를 출력 
		if(!list.isEmpty()) {
			Carmenu.displayRentCarList(list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}

	public void exitProgram() {

		RentcarService.exitProgram();
		
	}
	
}
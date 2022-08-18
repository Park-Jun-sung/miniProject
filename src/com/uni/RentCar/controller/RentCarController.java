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

public class RentCarController {

	private RentCarService RentcarService = new RentCarService();
	
	// StackOverflow가 남
	//public RentCarMenu Carmenu = new RentCarMenu();
	
	fin_List List_book_date = new fin_List();
	public ArrayList<RentCarDto> Final_appointment_Rentcar_list = new ArrayList<RentCarDto>();
	
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
		
		// rentcar_no
		//RentCarDto car_no = Carmenu.Final_reservation_car.get(0);
		
		
		int result = RentcarService.UpdatereturnDate("1001", Return_date, Return_second);
		
		// 아 반납은 차가 결정 되고 나서 반납 날짜가 정해져야 업데이트를 할 수 있구나.
		// 렌트카가 하나가 나올테니깐 
		
		if(result > 0 ) {	
			new RentCarMenu().displaySuccess("렌트카 정보 수정 성공");
		}else {
			new RentCarMenu().displayError("렌트카 정보 수정 실패");
		}
		
	}
	
	
	
	// 예약 날짜 선택 
	public void selectDate() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("인수 날짜를 입력하세요 : (예 20220809)");
		String str = sc.next();
		sc.nextLine();
		
		StrDate str_date = new StrDate();
		String Selec_date = str_date.strDate(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectDate(Selec_date);
	
		
		// =============================================
		// 인수 날짜 조회를 한것을 다른 최종 리스트에 저장.
		//if (Final_appointment_Rentcar_list != null) {
		Final_appointment_Rentcar_list = List_book_date.book_date(ca_list);	
		//}
		// =============================================
		
		if(!ca_list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			Carmenu.displayRentCarList(ca_list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
	}
	
	
	public void selectTime() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("인수 시간을 입력하세요 : (예 8AM -> 8, 2pm -> 14)");
		String str = sc.next();
		sc.nextLine();
		
		
		StrTime str_time = new StrTime();
		
		String Selec_time = str_time.str_time(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectTime(Selec_time);
		
		
		
		// ============================================
		// 인수 날짜 조회 한것을 다시 인수 시간으로 조회를 하고 최종리스트에 저장
		
		if (Final_appointment_Rentcar_list != null) {
			
			Final_appointment_Rentcar_list = List_book_date.book_time(Final_appointment_Rentcar_list, Selec_time);
			
		}
		// ============================================
		
		
		if(!ca_list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			Carmenu.displayRentCarList(ca_list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}



	public void selectAll() {
		
		RentCarMenu Carmenu = new RentCarMenu();
		
		ArrayList<RentCarDto> list = RentcarService.selectAll();
		
		if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			Carmenu.displayRentCarList(list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}
	
	
	public void selectCarSection() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("차 종을 선택하세요 (소형, 중형, SUV) : ");
		String str = sc.next();
		sc.nextLine();
		
		ArrayList<RentCarDto> list = RentcarService.selectsection(str);
		
				
		//Carmenu.displayfinRentCar(list);
		
		// =============================================
		// 인수 날짜,시간 조회를 한것을 차종을 선택해서 최종 리스트에 저장 
		if (Final_appointment_Rentcar_list != null) {
			
			Final_appointment_Rentcar_list = List_book_date.book_Carsection(Final_appointment_Rentcar_list);
		}
		
		// =============================================
		
		if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			Carmenu.displayRentCarList(list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}
	
	

	public void selectOne(String inputMemberId) {
		RentCarMenu Carmenu = new RentCarMenu();
		
		RentCarDto m = RentcarService.selectOne(inputMemberId);
		
		if(m != null) {
			Carmenu.displayMember(m);
		}else {
			Carmenu.displayError(inputMemberId + " 해당되는 데이터가 없습니다.");
		}
		
	}

	public void selectByName(String inputMemberName) {
		
		RentCarMenu menu = new RentCarMenu();
		
		List<RentCarDto> list = RentcarService.selectByName(inputMemberName);
		
		if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			menu.displayRentCarList(list);
		}else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}

	public void insertMember(RentCarDto inputMember) {
		
		int result = RentcarService.insertMember(inputMember);
		
		if(result > 0 ) {
			
			new RentCarMenu().displaySuccess("회원가입성공");
		}else {
			new RentCarMenu().displayError("회원가입실패");
		}
		
	}

	public void updateMember(RentCarDto updateMember) {
		
		int result = RentcarService.updateMember(updateMember);
		
		
		if(result > 0 ) {	
			new RentCarMenu().displaySuccess("렌트카 정보 수정 성공");
		}else {
			new RentCarMenu().displayError("렌트카 정보 수정 실패");
		}
		
	}

	public void deleteMember(String inputMemberId) {
		int result = RentcarService.deleteMember(inputMemberId);
		
		if(result > 0 ) {
			new RentCarMenu().displaySuccess("회원삭제성공");
		}else {
			new RentCarMenu().displayError("회원삭제실패");
		}
		
	}

	public void exitProgram() {

		RentcarService.exitProgram();
		
	}
	
}
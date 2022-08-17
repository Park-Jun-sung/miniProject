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
	
	// 예약 날짜 선택 
	public void selectDate() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("예약 날짜를 입력하세요 : (예 20220809)");
		String str = sc.next();
		sc.nextLine();
		
		StrDate str_date = new StrDate();
		String Selec_date = str_date.strDate(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectDate(Selec_date);
	
		
		// =============================================
		// 인수 날짜 조회를 한것을 다른 최종 리스트에 저장.
		fin_List List_book_date = new fin_List();
		List_book_date.book_date(ca_list);
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
		
		System.out.println("예약 시간을 입력하세요 : (예 8AM -> 8, 2pm -> 14)");
		String str = sc.next();
		sc.nextLine();
		
		
		StrTime str_time = new StrTime();
		
		String Selec_time = str_time.str_time(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectTime(Selec_time);
		
		// =============================================
		// 인수 시간 조회를 한것을 다른 최종 리스트에 저장.
		fin_List List_book_date = new fin_List();
		List_book_date.book_time(ca_list);
		// =============================================
		
		
		
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
			
			new RentCarMenu().displaySuccess("회원수정성공");
		}else {
			new RentCarMenu().displayError("회원수정실패");
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

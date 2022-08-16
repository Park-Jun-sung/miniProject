package com.uni.rentCar.controller;

import java.util.ArrayList;
import java.util.List;

import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.rentCar.model.service.RentCarService;
import com.uni.rentCar.view.RentCar_Menu;

public class RentCarController {

private RentCarService memberService = new RentCarService();
	
	public void selectAll() {
		
		RentCar_Menu Carmenu = new RentCar_Menu();
		
		ArrayList<RentCarDto> list = memberService.selectAll();
		
		if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			Carmenu.displayMemberList(list);
		}else {
			Carmenu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}

	public void selectOne(String inputMemberId) {
		
		RentCar_Menu menu = new RentCar_Menu();
		RentCarDto m = memberService.selectOne(inputMemberId);
		
		if(m != null) {
			menu.displayMember(m);
		}else {
			menu.displayError(inputMemberId + " 해당되는 데이터가 없습니다.");
		}
		
	}

	public void selectByName(String inputMemberName) {
		
		RentCar_Menu menu = new RentCar_Menu();
		
		List<RentCarDto> list = memberService.selectByName(inputMemberName);
		
		if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			menu.displayMemberList(list);
		}else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}

	public void insertMember(RentCarDto inputMember) {
		
		int result = memberService.insertMember(inputMember);
		
		if(result > 0 ) {
			
			new RentCar_Menu().displaySuccess("회원가입성공");
		}else {
			new RentCar_Menu().displayError("회원가입실패");
		}
		
	}

	public void updateMember(RentCarDto updateMember) {
		int result = memberService.updateMember(updateMember);
		
		if(result > 0 ) {
			
			new RentCar_Menu().displaySuccess("회원수정성공");
		}else {
			new RentCar_Menu().displayError("회원수정실패");
		}
		
	}

	public void deleteMember(String inputMemberId) {
		int result = memberService.deleteMember(inputMemberId);
		
		if(result > 0 ) {
			new RentCar_Menu().displaySuccess("회원삭제성공");
		}else {
			new RentCar_Menu().displayError("회원삭제실패");
		}
		
	}

	public void exitProgram() {

		memberService.exitProgram();
		
	}
	
}

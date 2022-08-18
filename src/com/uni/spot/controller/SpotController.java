package com.uni.spot.controller;

import java.util.ArrayList;
import java.util.List;

import com.uni.member.view.MemberMenu;
import com.uni.spot.model.dto.SpotDto;
import com.uni.spot.model.service.SpotService;
import com.uni.spot.view.SpotMenu;



/**
 * <pre>
 * Class : SpotController
 * Comment : 서비스단서 가져온 값을 뷰에 전달하여 출력함
 * History
 * 2022/08/18 (백승민) 처음 작성함
 * </pre>
 * @author 백승민
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class SpotController {
	
	private SpotService spotService = new SpotService();
	
	
	/**
	 * @param spot : 입력한 관광지명
	 */
	public void selectByName(String spot) { 
		
		SpotMenu menu = new SpotMenu();
		List<SpotDto> list = spotService.selectByName(spot); //서비스단에 전달하여 리스트타입으로 반환 받음.
		
		if(!list.isEmpty()) { // 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			menu.displaySpotList3(list);
		}else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}

	/**
	 * @param spot : 입력한 관광지명
	 */
	public void bookingSpot(String spot) { //예약을 위한 메서드
		
		
		List<SpotDto> list = spotService.selectByName(spot);
		int spotNo =1;
		for(SpotDto l : list) {
			
			spotNo=l.getSpotNo();
		}
		
		if(spotService.bookingSpot(spotNo) ==1) {
			System.out.println("예약이 완료 되었습니다.");
		}
		
	
	}
	
	
	/**
	 * @param city : 입력받은 지역
	 */
	public void selectBeach(int city) { //해수욕장 목록 출력을 위한 메서드
		
		ArrayList<SpotDto> list = spotService.selectBeach();
		SpotMenu menu = new SpotMenu();
		
		if(city==1) {//제주시인 경우
			
			if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
				menu.displaySpotList(list);
			}else {
				menu.displayError("해당되는 데이터가 없습니다.");
			}
			
		}else if(city==2) {//서귀포시인 경우
			
			if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
				menu.displaySpotList2(list);
			}else {
				menu.displayError("해당되는 데이터가 없습니다.");
			}
			
		}
	}
	
	/**
	 * @param city : 입력받은 지역
	 */
	public void selectMuseum(int city) {//박물관 목록 출력을 위한 메서드
		
		ArrayList<SpotDto> list = spotService.selectMuseum();
		SpotMenu menu = new SpotMenu();
		
		if(city==1) {//제주시인 경우
			
				if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
					menu.displaySpotList(list);
				}else {
					menu.displayError("해당되는 데이터가 없습니다.");
			}
			
		}else if(city==2) {//서귀포시인 경우
			
				if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
					menu.displaySpotList2(list);
				}else {
					menu.displayError("해당되는 데이터가 없습니다.");
				}
			
		}
	}


	/**
	 * @param city : 입력받은 지역
	 */
	public void selectPark(int city) {//공원 목록 출력을 위한 메서드
		
		ArrayList<SpotDto> list = spotService.selectPark();
		SpotMenu menu = new SpotMenu();
		
		if(city==1) {//제주시인 경우
			
			if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
				menu.displaySpotList(list);
			}else {
				menu.displayError("해당되는 데이터가 없습니다.");
			}
			
		}else if(city==2) {//서귀포시인 경우
			
			if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
				menu.displaySpotList2(list);
			}else {
				menu.displayError("해당되는 데이터가 없습니다.");
			}
			
		}
	}


	/**
	 * @param city : 입력받은 지역
	 */
	public void selectMarket(int city) { //전통시장 목록 출력을 위한 메서드
		
		ArrayList<SpotDto> list = spotService.selectMarket();
		SpotMenu menu = new SpotMenu();
		
		if(city==1) {//제주시인 경우
			
			if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
				menu.displaySpotList(list);
			}else {
				menu.displayError("해당되는 데이터가 없습니다.");
			}
			
		}else if(city==2) {//서귀포시인 경우
			
			if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
				menu.displaySpotList2(list);
			}else {
				menu.displayError("해당되는 데이터가 없습니다.");
			}
			
		}
	}


}

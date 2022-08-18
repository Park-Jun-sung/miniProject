package com.uni.spot.controller;

import java.util.ArrayList;
import java.util.List;

import com.uni.member.view.MemberMenu;
import com.uni.spot.model.dto.SpotDto;
import com.uni.spot.model.service.SpotService;
import com.uni.spot.view.SpotMenu;

public class SpotController {
	
	private SpotService spotService = new SpotService();
	
	
	public void selectByName(String spot) {
		
		SpotMenu menu = new SpotMenu();
		List<SpotDto> list = spotService.selectByName(spot);
		
		if(!list.isEmpty()) {// 리스트객체를 이미 만들었기때문에 null 이될수 없고 비워져있는지로 구분
			menu.displaySpotList3(list);
		}else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}


	public void bookingSpot(String spot) {
		
		
		List<SpotDto> list = spotService.selectByName(spot);
		int spotNo =1;
		for(SpotDto l : list) {
			
			spotNo=l.getSpotNo();
		}
		
		if(spotService.bookingSpot(spotNo) ==1) {
			System.out.println("예약이 완료 되었습니다다.");
		}
		
	
	}
	
	
	public void selectBeach(int city) {
		
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
	
	
	public void selectMuseum(int city) {
		
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


	
	public void selectPark(int city) {
		
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



	public void selectMarket(int city) {
		
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

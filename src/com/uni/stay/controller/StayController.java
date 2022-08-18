package com.uni.stay.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uni.stay.model.dto.BookingStay;
import com.uni.stay.model.dto.Stay;
import com.uni.stay.service.StayService;
import com.uni.stay.view.StayMenu;

public class StayController {
	
	private StayService stayService = new StayService();
	
	public void selectByNameList(String stayArea, int stayCode) {
		StayMenu menu = new StayMenu();
		List<Stay> s = stayService.selectByNameList(stayArea, stayCode);
		
		if(s != null) {
			menu.displayStayNameList(s);
		} else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
		
	}

	public void selectByStayInfo(String stayArea, int stayCode, Date stayDay, String stayName) {
		StayMenu menu = new StayMenu();
		List<String> s = stayService.selectByStayInfo(stayName);
//		List<BookingStay> bs2 = new ArrayList<BookingStay>();
		
		if(s != null) {
			menu.displayStayInfoList(s);
		} else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
	}

	public void selectByBookingConfirmInfo(String stayArea, int stayCode, Date stayDay, String stayName) {
		StayMenu menu = new StayMenu();
		List<String> s = stayService.selectByStayInfo(stayName);
//		List<BookingStay> bs2 = new ArrayList<BookingStay>();
		
		if(s != null) {
			menu.displayBookingConfirm(s);
		} else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
	}

}

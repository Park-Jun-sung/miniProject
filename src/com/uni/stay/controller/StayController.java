package com.uni.stay.controller;

import java.util.List;

import com.uni.stay.model.dto.Stay;
import com.uni.stay.service.StayService;
import com.uni.stay.view.StayMenu;

public class StayController {
	
	private StayService stayService = new StayService();
	
	public void selectByNameList(String stayArea, int stayCode) {
		StayMenu menu = new StayMenu();
		List<Stay> s = stayService.selectByNameList(stayArea, stayCode);
		
		if(s != null) {
			menu.displayStayList(s);
		} else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
		
		
	}

}

package com.uni.stay.controller;

import java.util.Date;
import java.util.List;

import com.uni.stay.model.dto.Booking;
import com.uni.stay.model.dto.Stay;
import com.uni.stay.service.StayService;
import com.uni.stay.view.StayMenu;


/**
 * <pre>
 * Class : StayController
 * Comment : 서비스단에서 반환된 값을 화면에 뿌려주기위한 연결클래스
 * History
 * 2022/08/17 (김성환) 처음 작성함
 * </pre>
 * @author 김성환
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class StayController {
	private StayService stayService = new StayService();
	
	/**
	 * @param stayArea ui에서 입력받은 String값(지역명)을 서비스단 메소드로 전달
	 * @param stayCode ui에서 입력받은 int값(숙소 구분)을 서비스단 메소드로 전달
	 */
	public void selectByNameList(String stayArea, int stayCode) {
		StayMenu menu = new StayMenu();
		List<Stay> s = stayService.selectByNameList(stayArea, stayCode);
		
		if(s != null) {
			menu.displayStayNameList(s);
		} else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
	}
	
	/**
	 * @param stayArea ui에서 입력받은 String값(지역명)을 서비스단 메소드로 전달
	 * @param stayCode ui에서 입력받은 int값(숙소 구분)을 서비스단 메소드로 전달
	 * @param stayDay ui에서 입력받은 date값(입실 일자)을 서비스단 메소드로 전달
	 * @param stayName ui에서 입력받은 String값(숙소명)을 서비스단 메소드로 전달
	 */
	public void selectByStayInfo(String stayArea, int stayCode, Date stayDay, String stayName) {
		StayMenu menu = new StayMenu();
		List<String> s = stayService.selectByStayInfo(stayName);
		
		if(s != null) {
			menu.displayStayInfoList(s);
		} else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
	}
	
	/**
	 * @param stayArea ui에서 입력받은 String값(지역명)을 서비스단 메소드로 전달
	 * @param stayCode ui에서 입력받은 int값(숙소 구분)을 서비스단 메소드로 전달
	 * @param stayDay ui에서 입력받은 date값(입실 일자)을 서비스단 메소드로 전달
	 * @param stayName ui에서 입력받은 String값(숙소명)을 서비스단 메소드로 전달
	 */
	public void selectByBookingConfirmInfo(String stayArea, int stayCode, Date stayDay, String stayName) {
		StayMenu menu = new StayMenu();
		List<String> s = stayService.selectByStayInfo(stayName);
		
		if(s != null) {
			menu.displayBookingConfirm(s);
		} else {
			menu.displayError("해당되는 데이터가 없습니다.");
		}
	}
	
	/**
	 * @param booking 예약테이블에 입력될 객체데이터
	 */
	public void insertBookingStay(Booking booking) {
		StayMenu menu = new StayMenu();
		int result = stayService.insertBookingStay(booking);
		
		if(result > 0) {
			menu.displayBooking();
		} else {
			menu.displayError("예약되지 않았습니다.");
		}
	}

}

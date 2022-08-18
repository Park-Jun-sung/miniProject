package com.uni.booking.controller;

import java.util.ArrayList;

import com.uni.booking.model.dto.BookingDTO;
import com.uni.booking.model.service.BookingListService;
import com.uni.booking.view.BookingListMenu;

public class BookingListController {
	private BookingListService bookingListService = new BookingListService();

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public void selectFlightBookingList() {
		BookingListMenu menu = new BookingListMenu();
		
		ArrayList<BookingDTO> list = bookingListService.selectFlightBookingList();
		menu.printBookingList(list);
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public void selectSpotBookingList() {
		BookingListMenu menu = new BookingListMenu();
		
		ArrayList<BookingDTO> list = bookingListService.selectSpotBookingList();
		menu.printBookingList(list);
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public void selectRentCarBookingList() {
		BookingListMenu menu = new BookingListMenu();
		
		ArrayList<BookingDTO> list = bookingListService.selectRentCarBookingList();
		menu.printBookingList(list);
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public void selectStayBookingList() {
		BookingListMenu menu = new BookingListMenu();
		
		ArrayList<BookingDTO> list = bookingListService.selectStayBookingList();
		menu.printBookingList(list);
	}

	public void setBookingPayment(int totalPrice) {
		BookingListMenu menu = new BookingListMenu();
		if(totalPrice != 0) {
			int payCode = menu.setPayCode();
			
			ArrayList<BookingDTO> flightList = bookingListService.selectFlightBookingList();
			ArrayList<BookingDTO> spotList = bookingListService.selectSpotBookingList();
			ArrayList<BookingDTO> rentcarList = bookingListService.selectRentCarBookingList();
			ArrayList<BookingDTO> stayList = bookingListService.selectStayBookingList();
			
			int payNo = bookingListService.createPayNo(payCode, totalPrice);
			if(payNo > 0) {
				ArrayList<BookingDTO> list = new ArrayList<BookingDTO>();
				list.addAll(flightList);
				list.addAll(spotList);
				list.addAll(rentcarList);
				list.addAll(stayList);
				
				boolean result = bookingListService.updateBooking(list, payNo);
				if(result) {
					menu.displaySuccess("결제 완료");
					menu.initTotalPrice();
				}else {
					menu.displayError("결제에 실패했습니다. 관리자에게 문의해주세요.");
				}
			}else {
				menu.displayError("결제번호 발췌에 실패했습니다. 관리자에게 문의해주세요.");
				return;
			}
		}else {
			menu.displayError("결제할 항목이 없습니다.");
		}
		
	}

	public void setCancelBooking(int bookingNo) {
		BookingListMenu menu = new BookingListMenu();
		
		int result = bookingListService.setCancelBooking(bookingNo);
		if(result == 1) {
			menu.displaySuccess("예약이 취소되었습니다.");
		}else {
			if(result == 9) {
				menu.displayError("취소할 예약 정보가 없습니다.");
			}else if(result == 8) {
				menu.displayError("이미 결제된 예약건은 취소할 수 없습니다.");
			}else {
				menu.displayError("예약 취소에 실패했습니다. 관리자에게 문의하세요.");
			}
		}
	}
	
}


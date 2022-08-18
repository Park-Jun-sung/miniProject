package com.uni.booking.controller;

import com.uni.booking.model.service.BookingListService;
import com.uni.booking.view.BookingListMenu;
import com.uni.member.model.dto.Member;

public class BookingListController {
	private BookingListService bookingListService = new BookingListService();

	public void selectAllBookingList(Member member) {
		BookingListMenu menu = new BookingListMenu();
		
	}

	public void selectFlightBookingList(Member member) {
		BookingListMenu menu = new BookingListMenu();
		
	}

	public void selectSpotBookingList(Member member) {
		BookingListMenu menu = new BookingListMenu();
		
	}

	public void selectRentCarBookingList(Member member) {
		BookingListMenu menu = new BookingListMenu();
		
	}

	public void selectStayBookingList(Member member) {
		BookingListMenu menu = new BookingListMenu();
		
	}
	
}


package com.uni.booking.model.service;

import static com.uni.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.uni.booking.model.dao.BookingListDAO;
import com.uni.booking.model.dto.BookingDTO;

/**
 * <pre>
 * Class : 클래스의 이름
 * Comment : 클래스에 대한 설명
 * History
 * 2020/09/08 (작성자) 처음 작성함
 * </pre>
 * @author 작성자
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class BookingListService {
	private BookingListDAO bookingListDAO = new BookingListDAO();

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public ArrayList<BookingDTO> selectFlightBookingList() {
		Connection conn = getConnection();
		ArrayList<BookingDTO> list = bookingListDAO.selectFlightBookingList(conn);
		return list;
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public ArrayList<BookingDTO> selectSpotBookingList() {
		Connection conn = getConnection();
		ArrayList<BookingDTO> list = bookingListDAO.selectSpotBookingList(conn);
		return list;
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public ArrayList<BookingDTO> selectRentCarBookingList() {
		Connection conn = getConnection();
		ArrayList<BookingDTO> list = bookingListDAO.selectRentCarBookingList(conn);
		return list;
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public ArrayList<BookingDTO> selectStayBookingList() {
		Connection conn = getConnection();
		ArrayList<BookingDTO> list = bookingListDAO.selectStayBookingList(conn);
		return list;
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public int createPayNo(int payCode, int totalPrice) {
		Connection conn = getConnection();
		int payNo = bookingListDAO.createPayNo(conn, payCode, totalPrice);
		if(payNo > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return payNo;
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public boolean updateBooking(ArrayList<BookingDTO> list, int payNo) {
		Connection conn = getConnection();
		boolean result = bookingListDAO.updateBooking(conn, list, payNo);
		if(result) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public int setCancelBooking(int bookingNo) {
		Connection conn = getConnection();
		int result = bookingListDAO.setCancelBooking(conn, bookingNo);
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	

}
